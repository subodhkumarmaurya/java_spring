package com.gregchance.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gregchance.mvc.models.Book;
import com.gregchance.mvc.repositories.BookRepository;
import com.gregchance.mvc.services.BookService;

@RestController
public class MainController {

	private final BookService bService;
	private final BookRepository bRepository;
	
	public MainController(BookService bService, BookRepository bRepository) {
		this.bService = bService;
		this.bRepository = bRepository;
	}
	
	@GetMapping("/api/books")
	public List<Book> index() {
		return bRepository.findAll();
	}
	
	@PostMapping("/api/books")
	public Book create(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("pages") Integer pages
			) {
		Book book = new Book(title, description, language, pages);
		return bRepository.save(book);
	}
	
	@PostMapping("/api/books/{id}")
	public Book update(
			@PathVariable("id") Long id, 
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("pages") Integer pages
				) {
		Book book = bService.findOne(id);
		book.setTitle(title);
		book.setDescription(description);
		book.setLanguage(language);
		book.setNumberOfPages(pages);
		return bRepository.save(book);
	}
	
	@GetMapping("api/delete/{id}")
	public void delete(
			@PathVariable("id") Long id
			) {
		Book book = bService.findOne(id);
		bRepository.delete(book);
	}
}
