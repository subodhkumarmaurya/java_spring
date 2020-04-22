package com.gregchance.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gregchance.mvc.models.Book;
import com.gregchance.mvc.repositories.BookRepository;
import com.gregchance.mvc.services.BookService;

@Controller
public class JSPController {

	private final BookService bServ;
	private final BookRepository bRepo;
	
	public JSPController(BookService bServ, BookRepository bRepo) {
		this.bServ = bServ;
		this.bRepo = bRepo;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Book> books = bRepo.findAll();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	@GetMapping("/books/new")
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		return "newbook.jsp";
	}
	@GetMapping("/books/{id}")
	public String book(
			@PathVariable("id") Long id,
			Model model
			) {
		Book book = bServ.findOne(id);
		model.addAttribute("book", book);
		return "book.jsp";
	}
	@GetMapping("/books/edit/{book_id}")
	public String edit(
			@PathVariable("book_id") Long id,
			Model model
			) {
		Book book = bServ.findOne(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	@GetMapping("/books/delete/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
		Book book = bServ.findOne(id);
		bRepo.delete(book);
		return "redirect:/";
	}
	
	
	@PostMapping("/books/new")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newbook.jsp";
		}
		bRepo.save(book);
		return "redirect:/";
	}
	@PostMapping("/books/edit/{book_id}")
	public String edit(@PathVariable("book_id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			book.setId(id);
			return "edit.jsp";
		}
		book.setId(id);
		bRepo.save(book);
		return "redirect:/";
	}

	
}
