package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.LoginInfo;
import com.revature.beans.User;
import com.revature.repository.UserRepo;

/*
 * Here is our service for User
 */
@Service
public class UserService {

	/*
	 * pulling all repositories for service
	 */
	@Autowired
	UserRepo userRepo;
	
	//GET method for all users
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepo.findAll();
	}
	
	//GET method for a specific user
	public Optional<User> getUser(int userId) {
		Optional<User> u = userRepo.findById(userId);
		return u;
	}

	//PUT method for updating a specific user
	public void updateUser(int uId, User user) {
		user.setPassword(this.hash(user.getPassword()));
		userRepo.save(user);
	}
	
	/**
	 * Hashes the password and inserts user into the database
	 * 
	 * @param user
	 * @return
	 */
	public User createUser(User user) {
		user.setPassword(this.hash(user.getPassword()));
		userRepo.save(user);
		return user;
	}
	
	public User validateUser(LoginInfo info) {
		List<User> users = this.retrieveAllUsers();
		for (User user : users) {
			System.out.println(user);
			System.out.println( this.hash(info.getPassword()));
			if (user.getUsername().equals(info.getUsername()) && this.hash(info.getPassword()).equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	/**
	 * @param password
	 * @return hashed password
	 */
	private String hash(String password) {
		String hashed = new HashingService().hashPassword(password);
		return hashed;
	}
}
