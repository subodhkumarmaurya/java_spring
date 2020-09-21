package com.gregchance.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gregchance.exam.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

	List<Task> findAll();
}
