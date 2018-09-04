package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.LoginInfo;
import com.revature.beans.User;
import com.revature.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public User getUser(int userId) {
		User u = userRepo.findOne(userId);
		u.setHash("");
		u.setSalt("");
		return u;
	}

	public List<User> retrieveAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	public User createUser(User user) {
		userRepo.save(user);
		return user;
	}

	public User validateUser(LoginInfo info) {
		List<User> users = this.retrieveAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(info.getUsername()) && this.hash(info.getPassword()).equals(user.getHash())) {
				return user;
			}
		}
		return null;
	}

	private String hash(String password) {
		
		return null;
	}
}
