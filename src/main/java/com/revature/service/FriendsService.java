package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.FriendsList;
import com.revature.beans.User;
import com.revature.repository.FriendsRepo;

@Service
public class FriendsService {

	@Autowired
	FriendsRepo friendsRepo;
	
	public List<User> getFriendsById(int id){
		List<FriendsList> fList = (List<FriendsList>) friendsRepo.findAll();
		List<User> friends = new ArrayList<User>();
		for(FriendsList friend : fList) {
			if(friend.getFriendsId1() == id) {
				friends.add(friend.getFriendsId2());
			}
		}
		
		return friends;
	}
}
