package com.gregchance.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gregchance.events.models.User;
import com.gregchance.events.repositories.UserRepo;
import com.gregchance.events.services.UserServ;
import com.gregchance.events.validator.UserValidator;

@Controller
public class MainController {

	private final UserRepo urepo;
	private final UserServ userv;
	private final UserValidator uvalid;
	
	public MainController(
			UserRepo urepo,
			UserServ userv,
			UserValidator uvalid
			) {
		this.urepo = urepo;
		this.userv = userv;
		this.uvalid = uvalid;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/login";
		}
		Long id = (Long) session.getAttribute("user_id");
		model.addAttribute("user",urepo.findById(id).orElse(null));
		return "dashboard.jsp";
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
