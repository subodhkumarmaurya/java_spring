package com.gregchance.dojosurvery.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/setresults")
		public String setResults(
				@RequestParam("name") String name,
				@RequestParam("dojo") String dojo,
				@RequestParam("language") String language,
				@RequestParam("comment") String comment, 
				HttpSession session
				) {
			session.setAttribute("name", name);
			session.setAttribute("dojo", dojo);
			session.setAttribute("language", language);
			session.setAttribute("comment", comment);
			return "redirect:/results";
		}
	
	@GetMapping("/results")
		public String result(HttpSession session, Model model) {
			if(session.getAttribute("language").equals("java")) {
				return "java.jsp";
			}
			model.addAttribute("name", session.getAttribute("name"));
			model.addAttribute("dojo", session.getAttribute("dojo"));
			model.addAttribute("language", session.getAttribute("language"));
			model.addAttribute("comment", session.getAttribute("comment"));
			return "result.jsp";
		}
}
