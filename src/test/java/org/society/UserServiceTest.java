package org.society;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.society.dao.UserDao;
import org.society.entities.User;
import org.society.exceptions.UserAlreadyExistsException;
import org.society.exceptions.UserNotFoundException;
import org.society.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTest {

	@MockBean
	private UserRepository userRepo;
	
	@Autowired
	private UserDao service;
	
	@Test
	public void getUsers() throws UserNotFoundException
	{
		User user1 = new User();
		user1.setFirstName("Abhishek");
		user1.setLastName("S");
		user1.setEmail("avi@gmail.com");
		user1.setContactno("9337936005");
		user1.setPassword("avi");
		user1.setUserId(1);	
		
		User user2 = new User();
		user2.setFirstName("Abhishek");
		user2.setLastName("S");
		user2.setEmail("avi@gmail.com");
		user2.setContactno("9337936005");
		user2.setPassword("avi");
		user2.setUserId(2);	
		when(userRepo.findAll()).thenReturn(Stream.of(user1,user2).collect(Collectors.toList()));
		assertEquals(2,service.viewUserList().size());
	}
	
	@Test 
	public void testSave() throws UserAlreadyExistsException {
		User user1 = new User();
		user1.setFirstName("Abhishek");
		user1.setLastName("S");
		user1.setEmail("avi@gmail.com");
		user1.setContactno("9337936005");
		user1.setPassword("avi");
		user1.setUserId(1);	
	 when(userRepo.save(user1)).thenReturn(user1).thenReturn(null);
	 assertEquals(user1,service.registerUser(user1)); }
	
	@Test
	public void getUserByMailTest()
	{
		User user1 = new User();
		user1.setFirstName("Abhishek");
		user1.setLastName("S");
		user1.setEmail("avi@gmail.com");
		user1.setContactno("9337936005");
		user1.setPassword("avi");
		user1.setUserId(1);	
		when(userRepo.findByEmail("avi@gmail.com")).thenReturn(user1).thenReturn(null);
		assertEquals(user1,service.getByEmail("avi@gmail.com"));
	}
	
	@Test
	public void testByEmailandPwd()
	{
		User user1 = new User();
		user1.setFirstName("Abhishek");
		user1.setLastName("S");
		user1.setEmail("avi@gmail.com");
		user1.setContactno("9337936005");
		user1.setPassword("avi");
		user1.setUserId(1);
		when(userRepo.findByEmailAndPassword("avi@gmail.com","avi")).thenReturn(user1);
		assertEquals(user1,service.findByEmailandPwd("avi@gmail.com", "avi"));
	}
	
	@Test
	public void findUserByIdTest() throws UserNotFoundException
	{
		User user1 = new User();
		user1.setFirstName("Abhishek");
		user1.setLastName("S");
		user1.setEmail("avi@gmail.com");
		user1.setContactno("9337936005");
		user1.setPassword("avi");
		user1.setUserId(1);
		when(userRepo.findById(1)).thenReturn(Optional.of(user1)).thenReturn(null);
		assertEquals(user1,service.findByUserId(1));
	}
	
	
}


