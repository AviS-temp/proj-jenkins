package org.society.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.entities.NominatedCandidates;
import org.society.service.ElectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/result")
@CrossOrigin("*")
 public class ElectionResultController {
@Autowired 
private ElectionResultService electionResultService;

Logger log=LoggerFactory.getLogger(ElectionResultController.class);

@GetMapping(path="view/voting/percentage") 
public double viewVotingPercentage() {
	 log.info("Voting percentage viewed.."); 
	 return electionResultService.viewVotingPercentage(); }
 
 @GetMapping(path="view/candidate/{candidateId}") 
 public double viewCandidateVotingPercent(@PathVariable int candidateId)  {
 log.info("Election result viewed via candidate..");
 return electionResultService.viewCandidateVotingPercent( candidateId) ; }
 
@GetMapping(path="view/highest/percent") 
public NominatedCandidates viewHighestVotingPercentCandidate() {
 log.info("Highest percentage secured viewed.."); 
 return electionResultService.viewHighestVotingPercentCandidate(); }

 @GetMapping(path="view/lowest/percent") 
 public NominatedCandidates viewLowestVotingPercentCandidate()  {
 log.info("Lowest percentage secured viewed.."); 
 return electionResultService.viewLowestVotingPercentCandidate(); }
 
 @GetMapping(path = "display/stats") 
 public HashMap<String, Integer> displayVotingStatistics() { 
	 log.info("Hashmap displayed.."); 
 return electionResultService.displayVotingStatistics(); }
 
 @GetMapping(path = "display/pollResult") 
 public HashMap<String, Double> displayPollingResult() { 
	 log.info("Poll Result.."); 
 return electionResultService.displayPollingResult(); }
 
 
 }