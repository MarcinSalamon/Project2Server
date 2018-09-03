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
	
	@Column(name="PASSWORD_HASH")
	private String hash;
	
	@Column(name="PASSWORD_SALT")
	private String salt;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="F_LIST_ID")
	@OneToMany(mappedBy="friends")
	private int friendsListId;
	
	@Column(name="ONLINE_STATUS")
	@OneToOne(mappedBy="status")
	private int onlineStatus;
}
