package org.society.controller;

import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.service.ElectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElectionResultController {
	@Autowired
	private ElectionResultService electionResultService;
	@PostMapping(path="add/result")
	public int addElectionResult(@RequestBody ElectionResult result) {
		return electionResultService.addElectionResult(result);
	}
	@GetMapping(path="view/result")
	public List<ElectionResult> viewElectionResultList(){
		return electionResultService.viewElectionResultList();
	}
	@GetMapping(path="view/result/{candidateId}")
	public ElectionResult viewCandidatewiseResult(@PathVariable int candidateId) {
		return electionResultService.viewCandidatewiseResult(candidateId);
	}
	@GetMapping(path="view/voting/percentage")
	public double viewVotingPercentage() {
		return electionResultService.viewVotingPercentage();
	}
	@GetMapping(path="view/candidate/{candidateId}")
	public double viewCandidateVotingPercent(@PathVariable int candidateId) {
	return electionResultService.viewCandidateVotingPercent( candidateId) ;
			}
	@GetMapping(path="view/highest/percent")
	public NominatedCandidates viewHighestVotingPercentCandidate() {
		return electionResultService.viewHighestVotingPercentCandidate();
	}
	@GetMapping(path="view/lowest/percent")
	public NominatedCandidates viewLowestVotingPercentCandidate() {
		return electionResultService.viewLowestVotingPercentCandidate();
	}
	
	
}
