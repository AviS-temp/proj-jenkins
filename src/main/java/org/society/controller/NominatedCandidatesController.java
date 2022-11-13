package org.society.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.dao.NominatedCandidatesDao;
import org.society.entities.NominatedCandidates;
import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.NominatedCandidateAlreadyExistsException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.service.NominatedCandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*November 5 - Suyog's Code*/

// Added this
@RestController
@RequestMapping("/candidate")
@CrossOrigin("*")
public class NominatedCandidatesController {
	
	// Changed this
	@Autowired
	private NominatedCandidatesDao nDao;
	
	// 13 Nov
	@Autowired
	private NominatedCandidatesService service;
	
	// 11 November - Adding Loggers
	Logger log=LoggerFactory.getLogger(NominatedCandidatesController.class);
	
	//10th Nov
	@PostMapping("/add")// /{id} is removed - 12 Nov
	public NominatedCandidates addNominatedCandidate(
			@RequestBody NominatedCandidates candidate/* , @PathVariable int id */) throws NominatedCandidateAlreadyExistsException {
		log.info("Nominated Candidate Added");
		return nDao.addNominatedCandidate(candidate/* ,id */);
	}
	@PutMapping("/update/{candidateId}")
	public int updateNominatedCandidateDetails(@RequestBody NominatedCandidates candidate, @PathVariable int candidateId) {
		return nDao.updateNominatedCandidateDetails(candidate);
	}
	
	@DeleteMapping("/delete/{candidateId}")
	public int deleteNominatedCandididate(@PathVariable int candidateId) {
		log.info("Nominated Candidate Deleted");
		return nDao.deleteNominatedCandididate(candidateId);
	}
	@GetMapping("/getlist")															
	public List<NominatedCandidates> viewNominatedCandidatesList(){
		log.info("List of nominated candidates viewed");
		return nDao.viewNominatedCandidatesList();
	}
	@GetMapping("/getBy/{id}")
	public NominatedCandidates searchByCandidateId(@PathVariable int id) {
		log.info("Nominated candidate viewed through Id");
		return nDao.searchByCandidateId(id);
	}
	
	// 13 Nov
	@GetMapping(path = "/getList/{voterId}")
	public List<NominatedCandidates> viewBySocietyName(@PathVariable String voterId) {
		
		return service.viewBySocietyName(voterId);
	}

}
