package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Conversation;
import com.revature.repository.ConversationRepo;

@Service
public class ConversationService {
	
	@Autowired
	ConversationRepo convRepo;
	
	public Conversation createConversation(Conversation conv) {
		convRepo.save(conv);
		return conv;
	}
}
