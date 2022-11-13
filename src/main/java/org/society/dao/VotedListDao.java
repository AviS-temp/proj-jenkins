package org.society.dao;

import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.entities.RegisteredSocietyVoters;
import org.society.entities.VotedList;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.VotedListAlreadyExistsException;
import org.society.exceptions.VotedListNotFoundException;
import org.society.repository.CooperativeSocietyRepository;
import org.society.repository.NominatedCandidatesRepository;
import org.society.repository.RegisteredSocietyVotersRepository;
import org.society.repository.VotedListRepository;
import org.society.service.VotedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*November 5 - Khushal's Code*/
@Service
public class VotedListDao implements VotedListService {

	// Changed this name
	@Autowired
	private VotedListRepository votedRepo;
	// Changed this name
	@Autowired
	private NominatedCandidatesRepository nomRepo;
	@Autowired
	private RegisteredSocietyVotersRepository regRepo;
	@Autowired
	private CooperativeSocietyRepository copRepo;

	@Override//checked 13 th nov
	public int castVotedList(VotedList votedList) throws VotedListAlreadyExistsException {
		// 10th Nov
		VotedList v = votedRepo.findByVoterId(votedList.getVoterId());
		if (v != null) {
			throw new VotedListAlreadyExistsException("You have voted already!!");
		} else {
			RegisteredSocietyVoters obj1=regRepo.findById(votedList.getVoterId()).get();
			//int societyId=obj1.getSociety().getSocietyId();
			//CooperativeSociety c=copRepo.findById(societyId).get();
			//votedList.setSocietyId(societyId);
			obj1.setCastedVote(true);
			VotedList v1=votedRepo.save(votedList);
			//obj1.setVotedList(v1);
			regRepo.save(obj1);
			return 1;
		}

	}

	@Override//checked 13 th nov
	public int updateVotedListDetails(VotedList votedList) throws VotedListNotFoundException {
		// 9Nov
		VotedList list = votedRepo.findById(votedList.getId()).get();
		if (list == null) {
			throw new VotedListNotFoundException("Voted List not found.");
		} else {
			votedRepo.save(votedList);
			return 1;
		}

	}

	@Override//checked 13 th nov
	public int deletedVotedListDetails(int id) throws VotedListNotFoundException {
		// 9Nov
		VotedList list = votedRepo.findById(id).get();
		if (list == null) {
			throw new VotedListNotFoundException("Voted List not found.");
		} else {
			votedRepo.deleteById(id);
			return 1;
		}
	}

	@Override//checked 13 th nov
	public List<VotedList> viewVotedList() throws VotedListNotFoundException {
		// 9Nov
		List<VotedList> list = votedRepo.findAll();
		if(list.isEmpty())
		{
			throw new VotedListNotFoundException("No voted list is found.");
		}
		else {
			return list;
		}
	}

	@Override//checked 13 th nov
	public VotedList searchByVoterId(int voterId) throws VotedListNotFoundException {
		// 9Nov
		VotedList votedList = votedRepo.findByVoterId(voterId);
		if(votedList==null)
		{
			throw new VotedListNotFoundException("Voted List not found.");
		}
		else {
			return votedList;

		}
	}

	@Override//checked 13 th nov
	public List<VotedList> searchByNominatedCandidateId(int candidateId) throws CastedVoteNotFoundException {
		List<VotedList> list = votedRepo.findByCandidateId(candidateId);
		if(list.isEmpty())
		{
			throw new CastedVoteNotFoundException("Record not present");
		}
		else
		{
			return list;

		}
	}

}
