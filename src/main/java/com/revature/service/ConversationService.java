package com.revature.service;

import java.util.ArrayList;
import java.util.List;

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

	public Iterable<Conversation> getConversationsByIds(Iterable<Integer> ids) {
		Iterable<Conversation> conversations = convRepo.findAllById(ids);
		return conversations;
	}

	public Iterable<Conversation> getConversationsById(int id) {
		Iterable<Conversation> conversations = convRepo.findByUId1(id);
		return conversations;
	}
}
