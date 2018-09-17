package com.revature.util;

import java.util.Comparator;

import com.revature.beans.Message;

public class MessageSort implements Comparator<Message> {

	@Override
	public int compare(Message m1, Message m2) {
		// TODO Auto-generated method stub
		return m1.getmId() - m2.getmId();
	}

}
