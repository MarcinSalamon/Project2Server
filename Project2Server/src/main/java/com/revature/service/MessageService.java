package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Message;
import com.revature.repository.MessageRepo;

@Service
public class MessageService {

	@Autowired
	MessageRepo messageService;
	
	public Message getMessage(int mId) {
		Message m = messageService.findOne(mId);
		return m;
	}
	
	public Message createMessage(Message m){
		messageService.save(m);
		return m;
	}
}
