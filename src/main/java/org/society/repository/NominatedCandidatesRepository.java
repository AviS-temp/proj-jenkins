package org.society.repository;

import org.society.entities.NominatedCandidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NominatedCandidatesRepository extends JpaRepository<NominatedCandidates,Integer> {

	NominatedCandidates findByNominationFormNo(String nominationFormNo);

}
