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
	
	/**
	 * persists a conversation
	 * @param conv takes in a conversation
	 * @return returns the same conversation
	 */
	public Conversation createConversation(Conversation conv) {
		convRepo.save(conv);
		return conv;
	}

	/**
	 * Gets all the conversations that are matching these ids
	 * 
	 * @param ids list of ids of conversations
	 * @return list of conversations
	 */
	public Iterable<Conversation> getConversationsById(int id) {
		Iterable<Conversation> conversations = convRepo.findByUId1(id);
		return conversations;
	}
}
