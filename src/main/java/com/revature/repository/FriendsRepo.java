package com.revature.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.FriendsList;

public interface FriendsRepo extends CrudRepository<FriendsList, Integer>{

}
