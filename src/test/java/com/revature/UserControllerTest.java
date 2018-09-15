package com.revature;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.service.UserService;
import com.revature.beans.*;

class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
	}

}
