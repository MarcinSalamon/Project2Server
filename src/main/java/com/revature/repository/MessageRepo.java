package com.revature.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Message;

//CRUD methods for our Message controller
public interface MessageRepo extends CrudRepository<Message, Integer>{

	Iterable<Message> getByConversationId(int id);
	
}
