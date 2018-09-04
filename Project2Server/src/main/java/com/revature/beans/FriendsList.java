package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FRIENDS_LIST")
public class FriendsList {
	
	@Id
	@Column
	private int f_id;
	
	@Column(name="U_ID_1")
	private int friendsId1;
	
	@Column(name="U_ID_2")
	private int friendsId2;

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public int getFriendsId1() {
		return friendsId1;
	}

	public void setFriendsId1(int friendsId1) {
		this.friendsId1 = friendsId1;
	}

	public int getFriendsId2() {
		return friendsId2;
	}

	public void setFriendsId2(int friendsId2) {
		this.friendsId2 = friendsId2;
	}

	public FriendsList() {
		super();
	}

}
