package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FRIENDS_LIST")
public class FriendsList {
	@Column(name="U_ID_1")
	@ManyToOne()
	private int friendsId1;
	
	@Column(name="U_ID_2")
	@ManyToOne()
	private int friendsId2;

}
