package com.revature.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<Conversation> getConversationsByIds(List<Integer> ids) {
		List<Conversation> conversations = (List<Conversation>) convRepo.findAllById(ids);
		return conversations;
	}
}
