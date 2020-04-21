package com.gregchance.events.controllers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gregchance.events.models.Comment;
import com.gregchance.events.models.Event;
import com.gregchance.events.models.User;
import com.gregchance.events.repositories.CommentRepo;
import com.gregchance.events.repositories.EventRepo;
import com.gregchance.events.repositories.UserRepo;
import com.gregchance.events.services.UserServ;
import com.gregchance.events.validator.UserValidator;

@Controller
public class MainController {

	private final UserRepo urepo;
	private final UserServ userv;
	private final UserValidator uvalid;
	private final EventRepo erepo;
	private final CommentRepo crepo;
	
	public MainController(
			UserRepo urepo,
			UserServ userv,
			UserValidator uvalid,
			EventRepo erepo,
			CommentRepo crepo
			) {
		this.urepo = urepo;
		this.userv = userv;
		this.uvalid = uvalid;
		this.erepo = erepo;
		this.crepo = crepo;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/login";
		}
		Long id = (Long) session.getAttribute("user_id");
		model.addAttribute("user",urepo.findById(id).orElse(null));
		model.addAttribute("events", erepo.findAll());
		model.addAttribute("event", new Event());
		return "dashboard.jsp";
	}
	@GetMapping("/events/show/{event_id}")
	public String showEvent(@PathVariable("event_id") Long id, Model model, HttpSession session) {
		Event event = erepo.findById(id).orElse(null);
		model.addAttribute("event", event);
		model.addAttribute("comments", crepo.findAll());
		model.addAttribute("comment", new Comment());
		return "showEvent.jsp";
	}
	@GetMapping("/events/join/{event_id}")
	public String joinEvent(@PathVariable("event_id") Long id, HttpSession session) {
		Event event = erepo.findById(id).orElse(null);
		User user = urepo.findById((Long) session.getAttribute("user_id")).orElse(null);
		event.getAttendees().add(user);
		erepo.save(event);
		return "redirect:/dashboard";
	}
	@GetMapping("/events/leave/{event_id}")
	public String leaveEvent(@PathVariable("event_id") Long id, HttpSession session) {
		Event event = erepo.findById(id).orElse(null);
		User user = urepo.findById((Long) session.getAttribute("user_id")).orElse(null);
		event.getAttendees().remove(user);
		erepo.save(event);
		return "redirect:/dashboard";
	}
	@GetMapping("/events/edit/{event_id}")
	public String editEvent(@PathVariable("event_id") Long id, Model model, HttpSession session) {
		Event event = erepo.findById(id).orElse(null);
		Long blah = (Long) session.getAttribute("user_id");
		if(!blah.equals(event.getHost().getId())) {
			return "redirect:/dashboard";
		}
		model.addAttribute("event", event);
		return "editEvent.jsp";
	}
	@GetMapping("/events/destroy/{event_id}")
	public String destroyEvent(@PathVariable("event_id") Long id) {
		Event event = erepo.findById(id).orElse(null);
		for(int i=0;i<event.getComments().size();i++) {
			crepo.delete(event.getComments().get(i));
		}
		erepo.delete(event);
		return "redirect:/dashboard";
	}
	
	
	@PostMapping("/events/new")
	public String createNewEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
		Date date = new Date();
		if(result.hasErrors()) {
			model.addAttribute("events", erepo.findAll());
			model.addAttribute("user", urepo.findById((Long)session.getAttribute("user_id")).orElse(null));
			if(event.getDate() != null) {
				if(date.after(event.getDate())) {
					model.addAttribute("error", "Date must be in the future");
				}		
			}
			return "dashboard.jsp";
		}
		if(date.after(event.getDate())) {
			model.addAttribute("error", "Date must be in the future");
			return "dashboard.jsp";
		}
		User user = urepo.findById((Long) session.getAttribute("user_id")).orElse(null);
		event.setHost(user);
		if(event.getAttendees() == null) {
			event.setAttendees(new ArrayList<User>());
		}
		event.getAttendees().add(user);
		erepo.save(event);
		return "redirect:/dashboard";
	}
	@PostMapping("/events/edit/{event_id}")
	public String doEditEvent(@PathVariable("event_id") Long id, @Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
//	Need to set attendees again here or I lose them
			event.setHost(urepo.findById((Long) session.getAttribute("user_id")).orElse(null));
			event.setId(id);
			return "editEvent.jsp";
		}
		Event e = erepo.findById(id).orElse(null);
		e.setName(event.getName());
		e.setDate(event.getDate());
		e.setLocation(event.getLocation());
//	Need to set attendees again here or I lose them
//		event.setHost(urepo.findById((Long) session.getAttribute("user_id")).orElse(null));
//		event.setId(id);
		erepo.save(e);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/comments/new/{event_id}")
	public String addNewComment(@PathVariable("event_id") Long id, @Valid @ModelAttribute("comment") Comment comment, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "showEvent.jsp";
		}
		User user = urepo.findById((Long) session.getAttribute("user_id")).orElse(null);
		Event event = erepo.findById(id).orElse(null);
		comment.setUser(user);
		comment.setEvent(event);
		crepo.save(comment);
		return "redirect:/events/show/"+id;
	}
	
	
//	Login and Registration
	
	@GetMapping("/registration")
	public String registerUser(Model model) {
		model.addAttribute("user", new User());
		return "register.jsp";
	}
	@PostMapping("/registration")
	public String doRegisterUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uvalid.validate(user, result);
		if(result.hasErrors()) {
			return "register.jsp";
		}
		userv.registerUser(user);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	@PostMapping("/login")
	public String doLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if(!userv.authenticateUser(email, password)) {
			model.addAttribute("error", "Incorrect email / password combination");
			return "login.jsp";	
		}
		User user = urepo.findByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
