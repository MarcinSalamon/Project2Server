package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Message;
import com.revature.repository.MessageRepo;

@Service
public class MessageService {

	@Autowired
	MessageRepo messageRepo;
	
	public Optional<Message> getMessage(int mId) {
		Optional<Message> m = messageRepo.findById(mId);
		return m;
	}
	
	public Message createMessage(Message m){
		messageRepo.save(m);
		return m;
	}
}
