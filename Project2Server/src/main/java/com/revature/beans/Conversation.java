package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CONVERSATION")
public class Conversation {
	@Id
	@SequenceGenerator(name = "CONVERSATION_SEQ", sequenceName = "CONVERSATION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONVERSATION_SEQ")
	@Column
	private int cId;
	
	@Column(name="U_ID_1")
	private int uId1;
	
	@Column(name="U_ID_2")
	private int uId2;

	public Conversation() {
		super();
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getuId1() {
		return uId1;
	}

	public void setuId1(int uId1) {
		this.uId1 = uId1;
	}

	public int getuId2() {
		return uId2;
	}

	public void setuId2(int uId2) {
		this.uId2 = uId2;
	}
	
}
