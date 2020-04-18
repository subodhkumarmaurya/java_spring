package com.gregchance.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gregchance.authentication.models.User;
import com.gregchance.authentication.repositories.UserRepo;
import com.gregchance.authentication.services.UserServ;

@Controller
public class UserController {

	private final UserRepo urepo;
	private final UserServ userv;
	
	public UserController(UserRepo urepo, UserServ userv) {
		this.urepo = urepo;
		this.userv = userv;
	}
	
    @GetMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @GetMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @PostMapping(value="/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route`
    	userv.registerUser(user);
    	urepo.save(user);
    	session.setAttribute("user", user.getId());
    	return "redirect:/home";
    }
    
    @PostMapping(value="/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    	if(userv.authenticateUser(email, password)) {
    		session.setAttribute("user", urepo.findByEmail(email).getId());
    		return "redirect:/home";
    	}
        // else, add error messages and return the login page
    	model.addAttribute("error", "Incorrect password / email combination");
    	return "loginPage.jsp";
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("user");
    	model.addAttribute("user", urepo.findById(id).orElse(null));
    	return "homePage.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
}
