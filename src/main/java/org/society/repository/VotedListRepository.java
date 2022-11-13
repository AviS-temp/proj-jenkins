package org.society.repository;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.VotedList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotedListRepository extends JpaRepository<VotedList,Integer> {
//VotedList findByVoter(RegisteredSocietyVoters voter);
	List<VotedList> findByCandidateId(int candidateId);
	VotedList findByVoterId(int voterId);
}
