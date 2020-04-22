package com.gregchance.template.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.gregchance.template.models.User;
import com.gregchance.template.repositories.UserRepo;

@Service
public class UserServ {

	private final UserRepo urepo;
	
	public UserServ(UserRepo urepo) {
		this.urepo = urepo;
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return urepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = urepo.findByEmail(email);
		if(user == null) {
			return false;
		} else if(BCrypt.checkpw(password, user.getPassword())) {
			return true;
		}
		return false;
	}
}
