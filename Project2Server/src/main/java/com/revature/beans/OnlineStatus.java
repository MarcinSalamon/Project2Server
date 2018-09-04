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

	public OnlineStatus() {
		super();
	}

	public int getStatuId() {
		return statuId;
	}

	public void setStatuId(int statuId) {
		this.statuId = statuId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
