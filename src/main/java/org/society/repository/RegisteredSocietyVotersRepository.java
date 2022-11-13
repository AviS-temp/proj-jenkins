package org.society.repository;

import javax.transaction.Transactional;

import org.society.entities.RegisteredSocietyVoters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface RegisteredSocietyVotersRepository extends JpaRepository<RegisteredSocietyVoters,Integer> {

	/*November 5 - added on its own*/
	RegisteredSocietyVoters findByVoterIdCardNo(String voterIdCardNo);

	/*November 5 - added on its own*/
	@Modifying
	@Transactional  // add these two, for deleting, or else throws error
	void deleteByVoterIdCardNo(String voterIdCardNo);


	// November 8
	RegisteredSocietyVoters findByPasswordAndVoterIdCardNo(String password, String voterIdCardNo);

	// November 9
	RegisteredSocietyVoters findByVoterIdCardNoAndEmailId(String voterIdCardNo, String emailId);

	// November 9
	RegisteredSocietyVoters findByEmailId(String emailId);
	
	/*
	 * @Query(
	 * value="SELECT rs.first_name,rs.last_name FROM registeredsocietyvoters_table rs\r\n"
	 * +
	 * "INNER JOIN nominatedcandidates_table nc ON rs.nominated_candidates_candidate_id\r\n"
	 * + "= nc.candidate_id",nativeQuery=true) List<String> viewCandidates();
	 */
}
