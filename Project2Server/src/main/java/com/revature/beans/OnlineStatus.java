package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ONLINE_STATUS")
public class OnlineStatus {
	@Id
	@Column(name="STATUS_ID")
	private int statuId;
	
	@Column(name="STATUS")
	private String status;
}
