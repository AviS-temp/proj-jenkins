package org.society.service;

import java.util.List;

import org.society.entities.VotedList;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.VotedListAlreadyExistsException;
import org.society.exceptions.VotedListNotFoundException;

public interface VotedListService {
	public int castVotedList(VotedList votedList) throws VotedListAlreadyExistsException;
	public int updateVotedListDetails(VotedList votedList) throws VotedListNotFoundException ;
	public int deletedVotedListDetails(int id) throws VotedListNotFoundException;
	public List<VotedList> viewVotedList() throws VotedListNotFoundException;
	public VotedList searchByVoterId(int voterId) throws VotedListNotFoundException;
	public List<VotedList> searchByNominatedCandidateId(int candidateId) throws CastedVoteNotFoundException;
}
