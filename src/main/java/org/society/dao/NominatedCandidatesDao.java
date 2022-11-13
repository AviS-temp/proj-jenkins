//November 8 - Suyog's Code
package org.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.NominatedCandidateAlreadyExistsException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.repository.CooperativeSocietyRepository;
import org.society.repository.NominatedCandidatesRepository;
import org.society.repository.RegisteredSocietyVotersRepository;
import org.society.service.NominatedCandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NominatedCandidatesDao implements NominatedCandidatesService {
	@Autowired
	private NominatedCandidatesRepository nominatedCandidatesRepository;
	
	@Autowired
	private RegisteredSocietyVotersRepository regRepo;
	
	@Autowired
	private CooperativeSocietyRepository coopRepo;
	
	@Override
	public NominatedCandidates addNominatedCandidate(
			NominatedCandidates candidate/* , int id */) 
	{
		
		NominatedCandidates nc = nominatedCandidatesRepository.findByNominationFormNo(candidate.getNominationFormNo());
		{
			NominatedCandidates nc1=nominatedCandidatesRepository.save(candidate);
			//voter.getNominatedCandidates().setCandidateId(nc1.getCandidateId());
			
			// 12 Nov - commented
			/*
			 * RegisteredSocietyVoters v=regRepo.findById(id).get();
			 * v.setNominatedCandidates(nc1);
			 */
			
			//v.getNominatedCandidates().setCandidateId(nc1.getCandidateId());
			//v.setNominatedCandidates(nc1.getCandidateId());
			
			// 12 Nov - commented
			/* regRepo.save(v); */
				
			return nc1;
		}
		
	}

	@Override
	public int updateNominatedCandidateDetails(NominatedCandidates candidate) {
		// 9Nov
		NominatedCandidates nc = nominatedCandidatesRepository.findByNominationFormNo(candidate.getNominationFormNo());

			nominatedCandidatesRepository.save(candidate);
			return 1;

	
	}

	@Override
	public int deleteNominatedCandididate(int candidateId) {
		// 9Nov
		NominatedCandidates nc = nominatedCandidatesRepository.findById(candidateId).get();
			nominatedCandidatesRepository.deleteById(candidateId);
			return 1;
	    
	}

	@Override
	public List<NominatedCandidates> viewNominatedCandidatesList() {
		// 9Nov
		List<NominatedCandidates> listOfNominatedCandidates = nominatedCandidatesRepository.findAll();
			return listOfNominatedCandidates;
	}

	@Override
	public NominatedCandidates searchByCandidateId(int id){
		// 9Nov
		NominatedCandidates nc = nominatedCandidatesRepository.findById(id).get();
			return nc;
		
	}

	@Override
	public NominatedCandidates addNominatedCandidate(NominatedCandidates candidate, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<NominatedCandidates> viewBySocietyName(String voterId) {
		RegisteredSocietyVoters r = regRepo.findByVoterIdCardNo(voterId);
		CooperativeSociety c = coopRepo.findById(r.getSociety().getSocietyId()).get();
		List<NominatedCandidates> list = nominatedCandidatesRepository.findAll();
		List<NominatedCandidates> list2 = new ArrayList<NominatedCandidates>();
		for(NominatedCandidates n : list)
		{
			if(n.getSocietyName().equals(c.getSocietyName()))
			{
				list2.add(n);
			}
		}
		return list2;
	}
	
}
