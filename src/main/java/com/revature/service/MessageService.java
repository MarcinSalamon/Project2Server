package com.revature.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Message;
import com.revature.repository.MessageRepo;
import com.revature.util.MessageSort;

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
	
	/**
	 * gets a message by its id
	 * 
	 * @param mId id of the message to get
	 * @return Optional of generic type Message, message with specified id
	 */
	public Optional<Message> getMessage(int mId) {
		Optional<Message> m = messageRepo.findById(mId);
		return m;
	}
	
	/**
	 * persists a message to the database
	 * 
	 * @param m message to be persisted
	 * @return message that was persisted
	 */
	public Message createMessage(Message m){
		messageRepo.save(m);
		return m;
	}

	/**
	 * gets all messages by given conversation id
	 * 
	 * @param id of the conversation to be retrieved
	 * @return messages associated with the conversation
	 */
	public Iterable<Message> getMessagesByConversationId(int id) {
		List<Message> messages = (List<Message>) messageRepo.getByConversationId(id);
		Collections.sort(messages, new MessageSort());
		return messages;
	}
}
