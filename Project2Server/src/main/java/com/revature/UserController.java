package com.revature;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.PUT, value="/user/{id}")
	public void updateUser(@RequestBody User user, @PathVariable("id") int uId) {
		userService.updateUser(uId, user);
	}
	
	@RequestMapping(value="/users")
	public List<User> getAllUsers() {
		return userService.retrieveAllUsers();
	}
	

}
