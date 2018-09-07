package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.LoginInfo;
import com.revature.beans.User;
import com.revature.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
		
	public Optional<User> getUser(int userId) {
		Optional<User> u = userRepo.findById(userId);
		return u;
	}

	public List<User> retrieveAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	public User createUser(User user) {
		user.setPassword(this.hash(user.getPassword()));
		userRepo.save(user);
		return user;
	}

	public User validateUser(LoginInfo info) {
		List<User> users = this.retrieveAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(info.getUsername()) && this.hash(info.getPassword()).equals(user.getPassword())) {
				user.setPassword("");
				return user;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param password
	 * @return hashed password
	 */
	private String hash(String password) {
		String hashed = new HashingService().hashPassword(password);
		return hashed;
	}
}
