package com.gregchance.taskmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gregchance.taskmanager.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

	List<Task> findAll();
}
