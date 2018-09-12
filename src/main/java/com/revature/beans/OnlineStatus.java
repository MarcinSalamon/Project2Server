package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Here we have our Online Status table that is mapped to our SQL database
 */
@Entity
@Table(name="ONLINE_STATUS")
public class OnlineStatus {
	@Id
	@Column(name="STATUS_ID")
	private int statuId;
	
	@Column(name="STATUS")
	private String status;

	public OnlineStatus() {
		super();
	}

	//getters n' setters
	public int getStatuId() {
		return statuId;
	}

	public void setStatuId(int statuId) {
		this.statuId = statuId;
	}

	public String getStatus() {
		return status;
	}

	//toString
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
