package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONVERSATION")
public class Conversation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int cId;
	
	@Column(name="U_ID_1")
	@OneToOne(mappedBy="uId")
	private int uId1;
	
	@Column(name="U_ID_2")
	@OneToOne(mappedBy="uId")
	private int uId2;
}
