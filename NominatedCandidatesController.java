package org.society.controller;

import java.util.List;

import org.society.entities.NominatedCandidates;
import org.society.service.NominatedCandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NominatedCandidatesController {
	@Autowired
private NominatedCandidatesService nominatedCandidatesService;
	@PostMapping(path="add/candidate")
	public int addNominatedCandidate(@RequestBody NominatedCandidates candidate) {
		return nominatedCandidatesService.addNominatedCandidate( candidate);
	}
	@PutMapping(path="update/candidate")
	public int updateNominatedCandidateDetails(@RequestBody NominatedCandidates candidate) {
		return nominatedCandidatesService.updateNominatedCandidateDetails(candidate);
	}
	
	@DeleteMapping(path="delete/candidate/{candidateId}")
	public int deleteNominatedCandididate(@PathVariable int candidateId) {
		return nominatedCandidatesService.deleteNominatedCandididate(candidateId);
	}
	@GetMapping(path="get/candidate")
	public List<NominatedCandidates> viewNominatedCandidatesList(){
		return nominatedCandidatesService.viewNominatedCandidatesList();
	}
	@GetMapping(path="getBy/{id}")
	public NominatedCandidates searchByCandidateId(@PathVariable int id) {
		return nominatedCandidatesService.searchByCandidateId(id);
	}
}
