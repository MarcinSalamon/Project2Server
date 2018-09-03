package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="M_ID")
	private int mId;
	
	@Column(name="U_ID")
	@OneToOne(mappedBy="uId")
	private int messageUserId;
	
	@Column(name="TIMESTAMP")
	private String timestamp;
	
	@Column(name="MESSAGE")
	private String message;
	
	@Column(name="CONVERSATION_ID")
	@ManyToOne
	private int conversationId;
}
