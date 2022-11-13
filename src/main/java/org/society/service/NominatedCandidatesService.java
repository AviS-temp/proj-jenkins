package org.society.service;

import java.util.List;

import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateAlreadyExistsException;
import org.society.exceptions.NominatedCandidateNotFoundException;

public interface NominatedCandidatesService {
	public NominatedCandidates addNominatedCandidate(NominatedCandidates candidate, int id);
	public int updateNominatedCandidateDetails(NominatedCandidates candidate);
	public int deleteNominatedCandididate(int candidateId);
	public List<NominatedCandidates> viewNominatedCandidatesList();
	public NominatedCandidates searchByCandidateId(int id);
	NominatedCandidates addNominatedCandidate(NominatedCandidates candidate) throws NominatedCandidateAlreadyExistsException;
	List<NominatedCandidates> viewBySocietyName(String voterId);
}
