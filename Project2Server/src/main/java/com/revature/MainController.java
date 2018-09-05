package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Conversation;
import com.revature.beans.LoginInfo;
import com.revature.beans.Message;
import com.revature.beans.User;
import com.revature.service.ConversationService;
import com.revature.service.MessageService;
import com.revature.service.UserService;

@RestController
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	ConversationService conversationService;
	
	/**
	 * 
	 * @return documentation
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "<html><body><h1>index</h1></body></html>";
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	/**
	 * local endpoint
	 * http://localhost:8080/api/v1/login
	 * 
	 * @param info is json with login and password fields
	 * @return user if username and password are correct
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginInfo info) {
		User validated = userService.validateUser(info);
		if(validated == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return ResponseEntity.ok(validated);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User registrationInfo){
		userService.createUser(registrationInfo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	
	@PostMapping("/conversation/{id}/message")
	public ResponseEntity<Object> newMessage(@RequestBody Message message){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
	}
	
	@PostMapping("/conversation")
	public ResponseEntity<Object> newConversation(@RequestBody Conversation conversation){
		conversationService.createConversation(conversation);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
}
