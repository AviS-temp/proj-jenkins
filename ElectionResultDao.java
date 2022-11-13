package org.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.VotedList;
import org.society.repository.ElectionResultRepository;
import org.society.repository.NominatedCandidatesRepository;
import org.society.repository.RegisteredSocietyVotersRepository;
import org.society.repository.VotedListRepository;
import org.society.service.ElectionResultService;
import org.society.service.VotedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ElectionResultDao implements ElectionResultService {
@Autowired
private ElectionResultRepository electionResultRepository;
@Autowired
private NominatedCandidatesRepository nominatedCandidatesRepository;
@Autowired
private VotedListRepository  votedListRepository;
@Autowired
private RegisteredSocietyVotersRepository registeredSocietyVotersRepository;
@Autowired
private VotedListService votedListService;
@Override
public int addElectionResult(ElectionResult result) {
	ElectionResult obj=electionResultRepository.save(result);
	if(obj==null) {return 0;}
	else {return 1;}

}

@Override
public List<ElectionResult> viewElectionResultList() {
	List<ElectionResult> list= electionResultRepository.findAll();
	return list;
	
}

@Override
public ElectionResult viewCandidatewiseResult(int candidateId) {
	NominatedCandidates obj=nominatedCandidatesRepository.findById(candidateId).get();
	ElectionResult obj1=obj.getElectionResult();
	
	ElectionResult obj2=electionResultRepository.findById(obj1.getId()).get();
	return obj2;
}
//8th Nov
@Override
public double viewVotingPercentage() {// voted list  socity voters
	
	double t= votedListRepository.findAll().size();
	double s= registeredSocietyVotersRepository.findAll().size();
	return (t/s)*100;
	//return (double)electionResultRepository.getById(id).get().getCandidateVotesPercentage();
	
}

@Override
public double viewCandidateVotingPercent(int candidateId) {
	long t=this.votedListService.searchByNominatedCandidateId(candidateId).size();
	long a= votedListRepository.findAll().size();
	return (t/a)*100;
	//neet to confirm
}

@Override
public void displayVotingStatistics() {
	
	
}

@Override
public NominatedCandidates viewHighestVotingPercentCandidate() {
	List<VotedList> list =votedListRepository.findAll();
	List<Integer> Idlist=new ArrayList();
	for(VotedList v:list) {
		Idlist.add(v.getCandidate().getCandidateId());
	}
	int finalId=0;
	double max=0;
	
	for(int id:Idlist) {
		double t=max;
		max=Math.max(max,viewCandidateVotingPercent(id) ); 
		if(t!=max) {
			finalId=id;
		}
	}
	return nominatedCandidatesRepository.findById(finalId).get();
	
}

@Override
public NominatedCandidates viewLowestVotingPercentCandidate() {
	
	List<VotedList> list =votedListRepository.findAll();
	List<Integer> Idlist=new ArrayList();
	for(VotedList v:list) {
		Idlist.add(v.getCandidate().getCandidateId());
	}
	int finalId=0;
	double max=125522;
	
	for(int id:Idlist) {
		double t=max;
		max=Math.min(max,viewCandidateVotingPercent(id) ); 
		if(t!=max) {
			finalId=id;
		}
	}
	return nominatedCandidatesRepository.findById(finalId).get();
	
}





@Override
public void displayPollingResult() {
	
	
} 
}
