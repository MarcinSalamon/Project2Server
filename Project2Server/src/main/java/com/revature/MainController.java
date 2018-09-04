package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.LoginInfo;
import com.revature.beans.User;
import com.revature.service.UserService;

@RestController
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "<html><body><h1>index</h1></body></html>";
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LoginInfo info) {
		return userService.validateUser(info);
	}
}
