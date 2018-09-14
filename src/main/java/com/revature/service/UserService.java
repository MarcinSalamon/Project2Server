package com.revature.service;

import java.util.ArrayList;
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
	
	/**
	 * retrieves a List of all users from the database
	 * @return
	 */
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepo.findAll();
	}
	
	/**
	 * retrieves a user by id
	 * 
	 * @param userId id of user to be retrieved
	 * @return Optional of generic User of specified user
	 */
	public Optional<User> getUser(int userId) {
		Optional<User> u = userRepo.findById(userId);
		return u;
	}

	/**
	 * updates user with values of the new user
	 * 
	 * @param uId user id
	 * @param user information of user to be persisted
	 */
	public void updateUser(int uId, User user) {
		user.setPassword(this.hash(user.getPassword()));
		userRepo.save(user);
	}
	
	/**
	 * Hashes the password and inserts user into the database
	 * 
	 * @param user takes in a user to be created
	 * @return user taken in
	 */
	public User createUser(User user) {
		user.setPassword(this.hash(user.getPassword()));
		userRepo.save(user);
		return user;
	}
	
	/**
	 * validates if the username and password are matching a user in the database
	 * 
	 * @param info information of the user
	 * @return user information that matches login information
	 */
	public User validateUser(LoginInfo info) {
		List<User> users = this.retrieveAllUsers();
		for (User user : users) {
			if (user.getUsername().equals(info.getUsername()) && this.hash(info.getPassword()).equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	/**
	 * hashes the password
	 * 
	 * @param password is the unhashed password
	 * @return hashed password
	 */
	private String hash(String password) {
		String hashed = new HashingService().hashPassword(password);
		return hashed;
	}

	/**
	 * returns all users matching user id list
	 * 
	 * @param friendIds ids of all users to be retrieved
	 * @return list of users retrieved
	 */
	public ArrayList<User> getUsers(ArrayList<Integer> friendIds) {
		return (ArrayList<User>) userRepo.findAllById(friendIds);
	}
}
