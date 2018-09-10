package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Message;
import com.revature.repository.MessageRepo;

/*
 * Here is our service to Messages
 */
@Service
public class MessageService {

	/*
	 * pulling all repositories for service
	 */
	@Autowired
	MessageRepo messageRepo;
	
	//GET method by a specific id
	public Optional<Message> getMessage(int mId) {
		Optional<Message> m = messageRepo.findById(mId);
		return m;
	}
	
	//POST method for creating a new message
	public Message createMessage(Message m){
		messageRepo.save(m);
		return m;
	}
}
