package com.gregchance.taskmanager.controllers;

import java.util.List;

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

import com.gregchance.taskmanager.models.Task;
import com.gregchance.taskmanager.models.User;
import com.gregchance.taskmanager.repositories.TaskRepo;
import com.gregchance.taskmanager.repositories.UserRepo;
import com.gregchance.taskmanager.services.UserServ;
import com.gregchance.taskmanager.validator.UserValidator;

@Controller
public class MainController {

	private final UserRepo urepo;
	private final UserServ userv;
	private final UserValidator uvalid;
	private final TaskRepo trepo;
	
	public MainController(
			UserRepo urepo,
			UserServ userv,
			UserValidator uvalid,
			TaskRepo trepo
			) {
		this.urepo = urepo;
		this.userv = userv;
		this.uvalid = uvalid;
		this.trepo = trepo;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/login";
		}
		Long id = (Long) session.getAttribute("user_id");
		model.addAttribute("user",urepo.findById(id).orElse(null));
		List<Task> sortedTasks = trepo.findAll();
		sortedTasks.sort((t1,t2)->t1.getId().compareTo(t2.getId()));
		model.addAttribute("tasks", sortedTasks);
		return "dashboard.jsp";
	}
	
//	Sort Dashboard Tasks
	
	@GetMapping("/sorthigh")
	public String sortHigh(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("user_id");
		model.addAttribute("user",urepo.findById(id).orElse(null));
		List<Task> sortedTasks = trepo.findAll();
		sortedTasks.sort((t1,t2)->t1.getPriority()-t2.getPriority());
		model.addAttribute("tasks", sortedTasks);
		return "dashboard.jsp";
	}
	@GetMapping("/sortlow")
	public String sortLow(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("user_id");
		model.addAttribute("user",urepo.findById(id).orElse(null));
		List<Task> sortedTasks = trepo.findAll();
		sortedTasks.sort((t1,t2)->t2.getPriority()-t1.getPriority());
		model.addAttribute("tasks", sortedTasks);
		return "dashboard.jsp";
	}
		
//	New Task
	
	@GetMapping("/tasks/new")
	public String newTask(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("users", urepo.findAll());
		return "newTask.jsp";
	}
	@PostMapping("/tasks/new")
	public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("users", urepo.findAll());
			return "newTask.jsp";
		}
		if(task.getAssignee() != null) {
			if(task.getAssignee().getAssignedTasks().size() > 2) {
				model.addAttribute("users", urepo.findAll());
				model.addAttribute("error", "User is already assigned to 3 tasks");
				return "newTask.jsp";	
			}
		}
		task.setCreator(urepo.findById((Long)session.getAttribute("user_id")).orElse(null));
		trepo.save(task);
		return "redirect:/dashboard";
	}
	
//	Show Task
	
	@GetMapping("/tasks/show/{task_id}")
	public String showTask(@PathVariable("task_id") Long taskId, Model model) {
		model.addAttribute("task", trepo.findById(taskId).orElse(null));
		return "showTask.jsp";
	}
	
//	Edit Task
	
	@GetMapping("/tasks/edit/{task_id}")
	public String editTask(@PathVariable("task_id") Long taskId, Model model, HttpSession session) {
		Task task = trepo.findById(taskId).orElse(null);
		model.addAttribute("task", task);
		model.addAttribute("users", urepo.findAll());
		if(!session.getAttribute("user_id").equals(task.getCreator().getId())) {
			return "redirect:/dashboard";
		}
		return "editTask.jsp";
	}
	@PostMapping("/tasks/edit/{task_id}")
	public String doEditTask(@PathVariable("task_id") Long taskId, @Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
		if(result.hasErrors()) {
			task.setId(taskId);
			model.addAttribute("users", urepo.findAll());
			return "editTask.jsp";
		}
		if(task.getAssignee() != null) {
			if(task.getAssignee().getAssignedTasks().size() > 2) {
				task.setId(taskId);
				model.addAttribute("users", urepo.findAll());
				model.addAttribute("error", "User is already assigned to 3 tasks");
				return "editTask.jsp";	
			}
		}
		Task t = trepo.findById(taskId).orElse(null);
		t.setName(task.getName());
		t.setAssignee(task.getAssignee());
		t.setPriority(task.getPriority());
		trepo.save(t);
		return "redirect:/dashboard";
	}
	
//	Delete Task
	
	@GetMapping("/tasks/destroy/{task_id}")
	public String deleteTask(@PathVariable("task_id") Long taskId) {
		trepo.deleteById(taskId);
		return "redirect:/dashboard";
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
