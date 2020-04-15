package com.gregchance.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gregchance.languages.models.Language;
import com.gregchance.languages.repositories.LanguageRepo;
import com.gregchance.languages.services.LanguageServ;

@Controller
@RequestMapping("/languages")
public class MainController {
	
	private final LanguageRepo lRepo;
	private final LanguageServ lServ;
	
	public MainController(LanguageRepo lRepo, LanguageServ lServ) {
		this.lRepo = lRepo;
		this.lServ = lServ;
	}
	

	@GetMapping("")
	public String index(Model model) {
		List<Language> l = lRepo.findAll();
		model.addAttribute("languages", l);
		model.addAttribute("language", new Language());
		return "index.jsp";
	}
	@GetMapping("/{language_id}")
	public String language(@PathVariable("language_id") Long id, Model model) {
		Language l = lServ.findOne(id);
		model.addAttribute("language", l);
		return "language.jsp";
	}
	@GetMapping("/edit/{language_id}")
	public String editLanguage(@PathVariable("language_id") Long id, Model model) {
		Language l = lServ.findOne(id);
		model.addAttribute("language", l);
		return "edit.jsp";
	}
	@GetMapping("/delete/{language_id}")
	public String delete(@PathVariable("language_id") Long id) {
		Language l = lServ.findOne(id);
		lRepo.delete(l);
		return "redirect:/languages";
	}
	
	@PostMapping("")
	public String newBook(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> l = lRepo.findAll();
			model.addAttribute("languages", l);
			return "index.jsp";
		}
		lRepo.save(language);
		return "redirect:/languages";
	}
	@PostMapping("/edit/{language_id}")
	public String editLanguage(@PathVariable("language_id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			language.setId(id);
			return "edit.jsp";
		}
		language.setId(id);
		lRepo.save(language);
		return "redirect:/languages";
	}
}
