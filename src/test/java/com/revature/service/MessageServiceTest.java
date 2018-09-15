package com.revature.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.revature.beans.Message;
import com.revature.repository.MessageRepo;

class MessageServiceTest {

	@Mock
	MessageRepo messageRepo;
	
	@InjectMocks
	private MessageService messageService;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void test() {
		
		Message message = new Message();
		
		message.setMessage("This is a test my dude");
		
		when(messageRepo.save(any(Message.class))).thenReturn(message);		
		System.out.println(message);
		
		assertEquals("This is a test my dude", message.getMessage());
	}

}
