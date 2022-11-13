package org.society.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.dao.VotedListDao;
import org.society.entities.VotedList;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.VotedListAlreadyExistsException;
import org.society.exceptions.VotedListNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*November 5 - Khushal's Code*/
@RestController
// Added this
@RequestMapping("/path")
@CrossOrigin("*")
public class VotedListController {
	
	// Changed this
	@Autowired
	private VotedListDao vDao;
	
	// 11 November - Adding Loggers
				Logger log=LoggerFactory.getLogger(VotedListController.class);
	
	@PostMapping(path = "/add")
	public int castVotedList(@RequestBody VotedList votedList) throws VotedListAlreadyExistsException
	{
		log.info("votedlist added..");
		return vDao.castVotedList(votedList);
	}
	@PutMapping(path = "/update")
	public int updateVotedListDetails(@RequestBody VotedList votedList) throws VotedListNotFoundException
	{
		log.info("votedlist updated..");
		return vDao.updateVotedListDetails(votedList);
	}
	@DeleteMapping(path = "/delete/{id}")
	public int deletedVotedListDetails(@PathVariable int id) throws VotedListNotFoundException
	{
		log.info("votedlist deleted..");
		return vDao.deletedVotedListDetails(id);
	}
	@GetMapping(path = "/viewAll")
	public List<VotedList> viewVotedList() throws VotedListNotFoundException
	{
		log.info("votedlist viewed..");
		return vDao.viewVotedList();
	}
	@GetMapping(path = "path/{voterId}")
	public VotedList searchByVoterId(@PathVariable int voterId) throws VotedListNotFoundException
	{
		log.info("votedlist searched by Id..");
		return vDao.searchByVoterId(voterId);
	}
	@GetMapping(path = "/candidate/{candidateId}")
	public List<VotedList> searchByNominatedCandidateId(@PathVariable int candidateId) throws CastedVoteNotFoundException
	{
		log.info("votedlist searched through candidate..");
		return vDao.searchByNominatedCandidateId(candidateId);
	}

}
