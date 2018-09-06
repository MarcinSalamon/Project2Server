package com.revature.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Message;

public interface MessageRepo extends CrudRepository<Message, Integer>{

}
