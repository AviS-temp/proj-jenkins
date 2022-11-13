package org.society.service;

import java.util.HashMap;
import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.ElectionResultAlreadyExistsException;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.exceptions.NominatedCandidateNotFoundException;

public interface ElectionResultService {
	public int addElectionResult(ElectionResult result) throws ElectionResultAlreadyExistsException;
	public List<ElectionResult> viewElectionResultList() throws ElectionResultNotFoundException;
	public ElectionResult viewCandidatewiseResult(int candidateId) throws NominatedCandidateNotFoundException, ElectionResultNotFoundException;
	public double viewVotingPercentage();
	public double viewCandidateVotingPercent(int candidateId) throws CastedVoteNotFoundException;
	//9Nov
	public HashMap<String, Integer> displayVotingStatistics();
	public NominatedCandidates viewHighestVotingPercentCandidate() throws CastedVoteNotFoundException;           // Nov 10
	public NominatedCandidates viewLowestVotingPercentCandidate() throws CastedVoteNotFoundException;
	//9Nov
	public HashMap<String, Double> displayPollingResult();
}
