package com.gregchance.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/checkcode") 
		public String checkCode(@RequestParam("code") String code, RedirectAttributes rA) {
			if(code.equalsIgnoreCase("bushido")) {
				return "guessedit.jsp";
			}
			rA.addFlashAttribute("error", "The price is wrong, b****!");
			return "redirect:/";
	}
}
