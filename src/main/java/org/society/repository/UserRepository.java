package org.society.repository;

import org.society.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	//8 November
	// Added for login purposes
	User findByEmailAndPassword(String email, String password);

	// 8 November
	// Added for email purposes
	User findByEmail(String email);

}
