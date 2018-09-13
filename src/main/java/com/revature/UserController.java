package com.revature;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Conversation;
import com.revature.beans.User;
import com.revature.service.ConversationService;
import com.revature.service.FriendsService;
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
	
	@Autowired
	FriendsService friendService;
	
	@Autowired
	ConversationService conversationService;
	
	/**
	 * local endpoint
	 * http://localhost:8080/user/{id}
	 * 
	 * @param id can change dynamically
	 * @return specific user if correct
	 */
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public Optional<User> getUser(@PathVariable int id) {
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
	public  ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable("id") int uId) {
		userService.updateUser(uId, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	/**
	 * local endpoint 
	 * http://localhost:8080/users
	 * 
	 * @return all users if correct
	 */
	@GetMapping(value="/user")
	public List<User> getAllUsers() {
		return userService.retrieveAllUsers();
	}
	
	/**
	 * endpoint ip:8080/user/{id}/friends
	 * @param id
	 * @return List of users that are you friends
	 */
	@GetMapping("/user/{id}/friend")
	public ResponseEntity<Object> getFriendsByUserId(@PathVariable int id){
		List<User> friends = friendService.getFriendsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(friends);
	}
	
	@GetMapping("/user/{id}/conversation")
	public ResponseEntity<Iterable<Conversation>> getConversationsByUserId(@PathVariable int id){
		Iterable<Conversation> conversations = conversationService.getConversationsById(id);
		return new ResponseEntity<Iterable<Conversation>>(conversations, HttpStatus.OK);
	}

}
