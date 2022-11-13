package org.society.repository;

import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.VotedList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotedListRepository extends JpaRepository<VotedList,Integer> {
VotedList findByVoter(RegisteredSocietyVoters voter);
}
