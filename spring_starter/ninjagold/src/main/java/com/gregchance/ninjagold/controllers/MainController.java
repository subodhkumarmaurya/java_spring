package com.gregchance.ninjagold.controllers;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		Date date = new Date();
		model.addAttribute("date", date);
		return "index.jsp";
	}
	
	@PostMapping("/setgold")
	public String setgold(HttpSession session,@RequestParam("git") String git) {
		if(session.getAttribute("log") == null) {
			session.setAttribute("log", "");
		}
		Date date = new Date();
		Random r = new Random();
		if(git.equalsIgnoreCase("farm")) {
			int gold = r.nextInt(10)+10;
			session.setAttribute("gold", (int) session.getAttribute("gold")+gold);
			session.setAttribute("log", (String) session.getAttribute("log")+"<p class='green'>You have earned "+gold+" gold. ("+date+")</p>");
//			session.setAttribute("log", (String) session.getAttribute("log")+"<p class='green'> <fmt:formatDate pattern='EEEE dd MMMM, yyyy' value='${date}'/> </p>");
//			session.setAttribute("log", (String) session.getAttribute("log")+"<p class='green'>"+date.toString()+"</p>");
		} else if(git.equalsIgnoreCase("cave")) {
			int gold = r.nextInt(5)+5;
			session.setAttribute("gold", (int) session.getAttribute("gold")+gold);
			session.setAttribute("log", (String) session.getAttribute("log")+"<p class='green'>You have earned "+gold+" gold. ("+date+")</p>");
		} else if(git.equalsIgnoreCase("house")) {
			int gold = r.nextInt(3)+2;
			session.setAttribute("gold", (int) session.getAttribute("gold")+gold);
			session.setAttribute("log", (String) session.getAttribute("log")+"<p class='green'>You have earned "+gold+" gold. ("+date+")</p>");
		} else if(git.equalsIgnoreCase("casino")) {
			int gold = r.nextInt(100)-50;
			session.setAttribute("gold", (int) session.getAttribute("gold")+gold);
			if(gold >= 0) {
				session.setAttribute("log", (String) session.getAttribute("log")+"<p class='green'>You have earned "+gold+" gold. ("+date+")</p>");
			} else {
				session.setAttribute("log", (String) session.getAttribute("log")+"<p class='red'>You have lost "+-gold+" gold. ("+date+")</p>");
			}
		}
		return "redirect:/";
	}
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
