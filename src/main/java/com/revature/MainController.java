package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Conversation;
import com.revature.beans.FriendsList;
import com.revature.beans.LoginInfo;
import com.revature.beans.Message;
import com.revature.beans.User;
import com.revature.service.ConversationService;
import com.revature.service.MessageService;
import com.revature.service.UserService;

/*
 * Here is the Main Controller to handle misc requests
 */
@RestController
public class MainController {
	
	/*
	 * Pulling all services need for controller
	 */
	@Autowired
	UserService userService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	ConversationService conversationService;
	
	/**
	 * @return documentation
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "<html><body><h1>index</h1></body></html>";
	}
	
	/**
	 * local endpoint
	 * http://localhost:8080/login
	 * 
	 * @param info is json with login and password fields
	 * @return user if username and password are correct
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody String[] creds) {
		System.out.println(creds[0] + " " + creds[1]);
		LoginInfo info = new LoginInfo(creds[0], creds[1]);
		User validated = userService.validateUser(info);
		if(validated == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return ResponseEntity.ok(validated);
	}
	
	/**
	 * local endpoint
	 * http://localhost:8080/register
	 * 
	 * @param registrationInfo
	 * @return user if correct
	 */
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User registrationInfo){
		userService.createUser(registrationInfo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	
	/**
	 * local endpoint
	 * http://localhost:8080/conversation/{id}/message
	 * 
	 * @param id can change dynamically
	 * @param message 
	 * @return message if correct
	 */
	@PostMapping("/conversations/{id}/message")
	public ResponseEntity<Object> newMessage(@PathVariable int id, @RequestBody Message message){
		if(message.getConversationId() != id) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}
		messageService.createMessage(message);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
	}
	
	/**
	 * local endpoint
	 * http://localhost:8080/conversations
	 * 
	 * @param conversation
	 * @return conversation if correct
	 */
	@PostMapping("/conversations")
	public ResponseEntity<Object> newConversation(@RequestBody Conversation conversation){
		conversationService.createConversation(conversation);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	
	@GetMapping("/conversations/{id}")
	public ResponseEntity<Object> getConversationById(@PathVariable int id){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(id);
		List<Conversation> convs = conversationService.getConversationsByIds(ids);
		Conversation conv = convs.get(0);
		return ResponseEntity.status(HttpStatus.OK).body(conv);
	}
	
	@ExceptionHandler
	public Object handleExceptions() {
		return HttpStatus.BAD_REQUEST;
	}
}
