package com.revature.beans;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

/*
 * Here we have our Message table that is mapped to our SQL database
 */
@Entity
@Table(name = "MESSAGE")
public class Message {

	@Id
	@SequenceGenerator(name = "MESSAGE_SEQ", sequenceName = "MESSAGE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGE_SEQ")
	@Column(name = "M_ID")
	private int mId;

	@Column(name = "U_ID")
	private int messageUserId;

	@Column(name = "TIME")
	@CreationTimestamp
	private LocalDateTime timestamp;

	@Column(name = "MESSAGE")
	private String message;

	@Column(name = "CONVERSATION_ID")
	private int conversationId;

	public Message() {
		super();
	}
	
	//getters n' setters
	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getMessageUserId() {
		return messageUserId;
	}

	public void setMessageUserId(int messageUserId) {
		this.messageUserId = messageUserId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getConversationId() {
		return conversationId;
	}

	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}


}
