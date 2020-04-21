package com.gregchance.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gregchance.events.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {

	List<Event> findAll();
}
