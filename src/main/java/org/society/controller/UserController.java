package org.society.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.dao.UserDao;
import org.society.entities.User;
import org.society.exceptions.UserAlreadyExistsException;
import org.society.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 5 Nov
// Khushal's code
@RestController
// Added this
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	// Changed this
	@Autowired
	private UserDao uDao;
	
	// 11 November - Adding Loggers
			Logger log=LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(path = "/register")											// 9 November
	public User registerUser(@RequestBody User user) throws UserAlreadyExistsException
	{
		log.info("New user added..");
		return uDao.registerUser(user);
	}
	//8 November
	// Changed for angular
	@PutMapping(path = "/update/{userId}")																	// 9 November
	public User updateUser(@PathVariable int userId, @RequestBody User user) throws UserNotFoundException
	{
		User u = uDao.findByUserId(userId);
		if(u!=null)
		{
			u.setContactno(user.getContactno());
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			User updatedUser = uDao.addUpdUser(u); // This needed to be changed as errors if not updating the email
			log.info("User got updated..");
			return updatedUser;
		}
		else
		{
			return null;
		}
	}
	@DeleteMapping(path = "/delete/{userId}")
	public int deleteUser(@PathVariable int userId) throws UserNotFoundException
	{
		log.info("User deleted..");
		return uDao.deleteUser(userId);
	}
	@GetMapping(path = "/viewAll")
	public List<User> viewUserList() throws UserNotFoundException
	{
		log.info("List of users viewed..");
		return uDao.viewUserList();
	}
	@GetMapping(path = "/view/{userId}")
	public User findByUserId(@PathVariable int userId) throws UserNotFoundException
	{
		log.info("User queried through Id");
		return uDao.findByUserId(userId);
	}
	
	//8 November
	// Method added for Login, not mentioned in ppts
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws UserNotFoundException
	{
		String email = user.getEmail();
		String pwd = user.getPassword();
		User existUser = null;
		if(email!=null&&pwd!=null)
		{
			log.info("User logged in..");
			existUser =uDao.findByEmailandPwd(email, pwd);	
		}
		if(existUser==null)
		{
			throw new UserNotFoundException("User does not exist");
		}
		return existUser;
	}
	
	// Added on November 8
	// For Mail Purposes
	@GetMapping("/byEmail/{email}")
	public User getByMail(@PathVariable String email)
	{
		log.info("User queried through email");
		return uDao.getByEmail(email);
	}

}
