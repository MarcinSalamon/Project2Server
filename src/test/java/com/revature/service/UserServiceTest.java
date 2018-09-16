package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.revature.beans.User;
import com.revature.repository.UserRepo;

//using it to mock object
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest()
class UserServiceTest {

	@Mock
	UserRepo userRepo;

	@InjectMocks
	private UserService userService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testCreateUser() {

		User user = new User();

		user.setFname("Jimmy");
		user.setLname("John");
		user.setEmail("JJ@yahoo.com");
		user.setUsername("JohnnyJim");

		when(userRepo.save(any(User.class))).thenReturn(user);

		User newUser = userService.userRepo.save(new User());
		System.out.println(newUser);

		assertEquals("Jimmy", newUser.getFname());
		assertEquals("John", newUser.getLname());
		assertEquals("JJ@yahoo.com", newUser.getEmail());
		assertEquals("JohnnyJim", user.getUsername());

	}
	
	final void testGetUser() {
		
	}

}
