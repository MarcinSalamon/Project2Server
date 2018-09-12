package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.FriendsList;
import com.revature.beans.User;
import com.revature.service.UserService;

/*
 * Here is the User Controller to handle User related requests
 */
@RestController
public class UserController {
	
	/*
	 * pulling all services needed for the controller
	 */
	@Autowired
	UserService userService;
	
	//Implementing logger
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	/**
	 * local endpoint
	 * http://localhost:8080/user/{id}
	 * 
	 * @param id can change dynamically
	 * @return specific user if correct
	 */
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public Optional<User> getUser(@PathVariable int id) {
		logger.info("[DEBUG] - in UserController.getUser()");
		return userService.getUser(id);
	}
	
	/**
	 * local endpoint 
	 * http://localhost:8080/user/{id}
	 * 
	 * @param user 
	 * @param uId can change dynamically
	 * @return a specifically updated user if correct
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/user/{id}")
	public  ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int uId) {
		userService.updateUser(uId, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	/**
	 * local endpoint 
	 * http://localhost:8080/users
	 * 
	 * @return all users if correct
	 */
	@RequestMapping(value="/users")
	public List<User> getAllUsers() {
		return userService.retrieveAllUsers();
	}

	@GetMapping("/user/{id}/friends")
	public ResponseEntity<Object> getFriendsByUserId(@PathVariable int id){
		Optional<User> dbUser = userService.getUser(id);
		ArrayList<User> friends = new ArrayList<User>();
		if(dbUser.isPresent()) {
			User user = dbUser.get();
			ArrayList<Integer> friendIds = new ArrayList<Integer>();
			for(FriendsList friend : user.getFriends()) {
				friendIds.add(friend.getFriendsId2());
			}
			
			friends = userService.getUsers(friendIds);
		}
		return ResponseEntity.status(HttpStatus.OK).body(friends);
	}
	
	@ExceptionHandler
	public Object handleExceptions() {
		return HttpStatus.BAD_REQUEST;
	}
}
