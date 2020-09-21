package com.gregchance.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer count = (Integer) session.getAttribute("count");
//		count += 1;
		session.setAttribute("count", count+1);
		System.out.println("In /, "+session.getAttribute("count"));
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		System.out.println("In /counter, "+session.getAttribute("count"));
		model.addAttribute("count", count);
		return "count.jsp";
	}
}
