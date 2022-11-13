package org.society.service;

import java.util.List;

import org.society.entities.User;
import org.society.exceptions.UserAlreadyExistsException;
import org.society.exceptions.UserNotFoundException;

public interface UserService {
	// 8 November
	// Changed for angular purposes
	
	// Added exceptions - 9 November
	public User registerUser(User user) throws UserAlreadyExistsException;
	public int updateUser(User user) throws UserNotFoundException;
	public int deleteUser(int userId) throws UserNotFoundException;
	public List<User> viewUserList() throws UserNotFoundException;
	public User findByUserId(int userId) throws UserNotFoundException;
}
