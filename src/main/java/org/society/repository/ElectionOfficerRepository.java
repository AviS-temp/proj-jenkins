package org.society.repository;

import org.society.entities.ElectionOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionOfficerRepository extends JpaRepository<ElectionOfficer,Integer> {

	// November 9 added on its own
	ElectionOfficer findByEmailIdAndPassword(String email, String pwd);

	// November 9
	ElectionOfficer findByEmailId(String emailId);

}
