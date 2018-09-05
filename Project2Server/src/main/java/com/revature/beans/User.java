package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="U_ID")
	private int uId;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="PW_HASH")
	private String hash;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="F_LIST_ID")
	private int friendsListId;
	
	@Column(name="ONLINE_STATUS")
	private int onlineStatus;

	public User() {
		super();
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getFriendsListId() {
		return friendsListId;
	}

	public void setFriendsListId(int friendsListId) {
		this.friendsListId = friendsListId;
	}

	public int getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(int onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", fname=" + fname + ", lname=" + lname + ", hash=" + hash + ", email=" + email
				+ ", username=" + username + ", friendsListId=" + friendsListId + ", onlineStatus=" + onlineStatus
				+ "]";
	}
}
