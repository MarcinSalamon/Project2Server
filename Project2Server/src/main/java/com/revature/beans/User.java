package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
	@Column(name="U_ID")
	private int uId;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="PW_HASH")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="ONLINE_STATUS")
	private int onlineStatus;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="F_ID")
	private List<FriendsList> friends;

	public User() {
		super();
	}

	public int getuId() {
		return uId;
	}

	public List<FriendsList> getFriends() {
		return friends;
	}

	public void setFriends(List<FriendsList> friends) {
		this.friends = friends;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(int onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", fname=" + fname + ", lname=" + lname + ", password=" + password + ", email=" + email
				+ ", username=" + username + ", onlineStatus=" + onlineStatus + "]";
	}
}
