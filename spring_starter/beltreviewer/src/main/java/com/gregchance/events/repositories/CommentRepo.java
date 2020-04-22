package com.gregchance.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gregchance.events.models.Comment;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

	List<Comment> findAll();
}
