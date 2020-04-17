package com.gregchance.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gregchance.dojosninjas.models.Dojo;
import com.gregchance.dojosninjas.models.Ninja;
import com.gregchance.dojosninjas.repositories.DojoRepo;
import com.gregchance.dojosninjas.repositories.NinjaRepo;

@Controller
public class MainController {

	private final DojoRepo drepo;
	private final NinjaRepo nrepo;
	
	public MainController(DojoRepo drepo, NinjaRepo nrepo) {
		this.drepo = drepo;
		this.nrepo = nrepo;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dojos", drepo.findAll());
		model.addAttribute("ninjas", nrepo.findAll());
		model.addAttribute("c", 0);
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String createDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "createdojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String doCD(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "createdojo.jsp";
		}
		drepo.save(dojo);
		return "redirect:/";
	}
	
	@GetMapping("ninjas/new")
	public String createNinja(Model model) {
		model.addAttribute("dojos", drepo.findAll());
		model.addAttribute("ninja", new Ninja());
		return "createninja.jsp";
	}
	@PostMapping("ninjas/new")
	public String doCN(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", drepo.findAll());
			return "createninja.jsp";
		}
		nrepo.save(ninja);
		return "redirect:/";
	}
	
	@GetMapping("/dojo/{dojo_id}")
	public String showDojo(@PathVariable("dojo_id") Long id, Model model) {
//		Dojo dojo = drepo.findById(id).orElse(null);
		model.addAttribute("dojo", drepo.findById(id).orElse(null));
		return "dojo.jsp";
	}
}
