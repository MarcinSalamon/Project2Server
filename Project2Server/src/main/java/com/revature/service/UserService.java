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
	
	@Autowired
	UserService service;
	
	public User getUser(int userId) {
		User u = userRepo.findOne(userId);
		u.setHash("");
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
				System.out.println(user);
				user.setHash("");
				return user;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	private String hash(String password) {
		String hashed = new HashingService().hashPassword(password);
		System.out.println(hashed);
		return hashed;
	}
}