package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Conversation;
import com.revature.repository.ConversationRepo;

/*
 * Here is our Services for our Conversations
 */
@Service
public class ConversationService {
	
	/*
	 * pulling all Repositories for service
	 */
	@Autowired
	ConversationRepo convRepo;
	
	//POST method for conversation
	public Conversation createConversation(Conversation conv) {
		convRepo.save(conv);
		return conv;
	}
}
