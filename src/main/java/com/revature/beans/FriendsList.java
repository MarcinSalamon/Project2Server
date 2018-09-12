package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Here we have our Friends List table that is mapped to our SQL database
 */
@Entity
@Table(name="FRIENDS_LIST")
public class FriendsList {
	
	@Id
	@Column(name="F_ID")
	private int fId;
	
	@Column(name="U_ID_1")
	private int friendsId1;


	@OneToOne
	@JoinColumn(name="U_ID_2")
	private User friendsId2;
  
  public FriendsList() {
		super();
	}
	
  //getters n' setters
<<<<<<< HEAD
	public int getFriendsId2() {
		return friendsId2;
	}

	public void setFriend(int friendsId2) {
		this.friendsId2 = friendsId2;
	}

	public int getF_id() {
		return fId;
	}
=======
	public int getfId() {
  		return fId;
  }
>>>>>>> 370eead5f7fbfab377b558af577ab29d9457ef67

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getFriendsId1() {
		return friendsId1;
	}

	public void setFriendsId1(int friendsId1) {
		this.friendsId1 = friendsId1;
	}
<<<<<<< HEAD
=======
  
	public User getFriendsId2() {
		return friendsId2;
	}
>>>>>>> 370eead5f7fbfab377b558af577ab29d9457ef67

	public void setFriendsId2(User friendsId2) {
		this.friendsId2 = friendsId2;
	}

}
