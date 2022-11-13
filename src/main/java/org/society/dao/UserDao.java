package org.society.dao;

import java.util.List;
import org.society.entities.User;
import org.society.exceptions.UserAlreadyExistsException;
import org.society.exceptions.UserNotFoundException;
import org.society.repository.UserRepository;
import org.society.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*November 5*/
// Khushal's Code

@Service
public class UserDao implements UserService {

	// 5 Nov
	@Autowired
	private UserRepository repository;

	@Override
	// 8 November
	// Changed for angular

	public User registerUser(User user) throws UserAlreadyExistsException {
		// 9Nov
		User u = repository.findByEmail(user.getEmail());
		if (u != null) {
			throw new UserAlreadyExistsException("User already present.");
		} else {
			return (repository.save(user));
		}
	}
	
	public User addUpdUser(User user){
		//11 Nov
		User u = repository.findByEmail(user.getEmail());
		return (repository.save(user));
	}

	@Override
	public int updateUser(User user) throws UserNotFoundException {
		// 9Nov
		User u = repository.findById(user.getUserId()).get();
		if (u == null) {
			throw new UserNotFoundException("User doesn't exists.");
		} else {
			User USER = repository.save(user);
			if (USER == null)
				return 0;
			else
				return 1;

		}

	}

	@Override
	public int deleteUser(int userId) throws UserNotFoundException {
		// 9Nov
		User u = repository.findById(userId).get();
		if (u == null) {
			throw new UserNotFoundException("User doesn't exists.");
		} else {
			repository.deleteById(userId);
			if (repository.existsById(userId))
				return 0;
			else
				return 1;
		}

	}

	@Override
	public List<User> viewUserList() throws UserNotFoundException {
		List<User> userList = repository.findAll();
		if(userList.isEmpty())
		{
			throw new UserNotFoundException("No users present.");
		}
		else
		{
			return userList;
		}
	}

	@Override
	public User findByUserId(int userId) throws UserNotFoundException {
		// 9Nov
		User u = repository.findById(userId).get();
		if (u == null) {
			throw new UserNotFoundException("User doesn't exists.");
		}
		else
		{
			return u;
		}
	}

	// 8 November
	// Added as per the controller
	// New
	public User findByEmailandPwd(String email, String pwd) {
		return repository.findByEmailAndPassword(email, pwd);
	}

	public User getByEmail(String email) {
		return repository.findByEmail(email);
	}

}
