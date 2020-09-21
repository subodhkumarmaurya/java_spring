package com.gregchance.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gregchance.mvc.models.Book;
import com.gregchance.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bRepo;
	
	public BookService(BookRepository bRepo) {
		this.bRepo = bRepo;
	}
	
	public Book findOne(Long id) {
		Optional<Book> optionalBook = bRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}
	
	
}
