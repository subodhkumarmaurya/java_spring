package com.gregchance.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gregchance.productscategories.models.Cat;

@Repository
public interface CatRepo extends CrudRepository<Cat, Long> {
	
    List<Cat> findAll();
}
