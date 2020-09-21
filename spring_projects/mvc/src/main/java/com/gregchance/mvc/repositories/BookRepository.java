package com.gregchance.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gregchance.mvc.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();

}
