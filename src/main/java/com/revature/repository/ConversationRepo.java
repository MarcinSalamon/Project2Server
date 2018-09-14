package com.revature.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Conversation;

//CRUD methods for our Conversation controller
public interface ConversationRepo extends CrudRepository<Conversation, Integer>{

	Iterable<Conversation> findByUId1(int id);
	
	Iterable<Conversation> findByUId1OrUId2(int id, int id2);
}
