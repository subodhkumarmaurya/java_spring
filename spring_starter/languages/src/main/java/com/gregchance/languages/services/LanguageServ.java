package com.gregchance.languages.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gregchance.languages.models.Language;
import com.gregchance.languages.repositories.LanguageRepo;

@Service
public class LanguageServ {

	private final LanguageRepo lRepo;
	
	public LanguageServ(LanguageRepo lRepo) {
		this.lRepo = lRepo;
	}
	
	public Language findOne(Long id) {
		Optional<Language> l = lRepo.findById(id);
		if(l.isPresent()) {
			return l.get();
		}
		return null;
	}
}
