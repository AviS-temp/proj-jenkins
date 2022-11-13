package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.repository.NominatedCandidatesRepository;
import org.society.service.NominatedCandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NominatedCandidatesDao implements NominatedCandidatesService {
	@Autowired
	private NominatedCandidatesRepository nominatedCandidatesRepository;
	@Override
	public int addNominatedCandidate(NominatedCandidates candidate) {
		NominatedCandidates candidateObj=nominatedCandidatesRepository.save(candidate);
		if(candidateObj==null) {return 0;}
		else return 1;
	
	}

	@Override
	public int updateNominatedCandidateDetails(NominatedCandidates candidate) {
		
		NominatedCandidates candidateObj=nominatedCandidatesRepository.save(candidate);
		if(candidateObj==null) {return 0;}
		else return 1;
	}

	@Override
	public int deleteNominatedCandididate(int candidateId) {
		
		nominatedCandidatesRepository.deleteById(candidateId);
	    if(nominatedCandidatesRepository.existsById(candidateId))
	    {
			return 1;
	    }
	    return 0;
	}

	@Override
	public List<NominatedCandidates> viewNominatedCandidatesList() {
		
		List<NominatedCandidates> listOfNominatedCandidates = nominatedCandidatesRepository.findAll();
		return listOfNominatedCandidates;
	}

	@Override
	public NominatedCandidates searchByCandidateId(int id)  {
		
		NominatedCandidates obj=nominatedCandidatesRepository.findById(id).get();
		if(obj==null) {
			return null;
		}
		else return obj;
	}
	
}
