package com.gregchance.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellohumanController {
	
	@RequestMapping("/")
	public String hello(@RequestParam(value="fn", required=false) String fn, @RequestParam(value="ln", required=false) String ln) {
		if(fn == null || ln == null) {
			return "Hello human";
		}
		return ("Hello "+fn+" "+ln);
	}
}
