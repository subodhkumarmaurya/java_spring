package com.gregchance.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gregchance.authentication.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	List<User> findAll();
	User findByEmail(String email);
}
