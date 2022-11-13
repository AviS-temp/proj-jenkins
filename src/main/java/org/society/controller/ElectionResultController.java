/*
 * //November 8 -Suyog's Code package org.society.controller;
 * 
 * import java.util.HashMap;
 * 
 * import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.society.entities.ElectionResult; import
 * org.society.entities.NominatedCandidates; import
 * org.society.exceptions.CastedVoteNotFoundException; import
 * org.society.exceptions.ElectionResultAlreadyExistsException; import
 * org.society.exceptions.ElectionResultNotFoundException; import
 * org.society.exceptions.NominatedCandidateNotFoundException; import
 * org.society.service.ElectionResultService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController public class ElectionResultController {
 * 
 * @Autowired private ElectionResultService electionResultService;
 * 
 * // 11 November - Adding Loggers Logger
 * log=LoggerFactory.getLogger(ElectionResultController.class);
 * 
 * @PostMapping(path="add/result") public int addElectionResult(@RequestBody
 * ElectionResult result) throws ElectionResultAlreadyExistsException {
 * log.info("Election Result added.."); return
 * electionResultService.addElectionResult(result); }
 * 
 * @GetMapping(path="view/result") public List<ElectionResult>
 * viewElectionResultList() throws ElectionResultNotFoundException{
 * log.info("Election result viewed.."); return
 * electionResultService.viewElectionResultList(); }
 * 
 * @GetMapping(path="view/result/{candidateId}") public ElectionResult
 * viewCandidatewiseResult(@PathVariable int candidateId) throws
 * NominatedCandidateNotFoundException, ElectionResultNotFoundException {
 * log.info("Election result viewed by candidateId.."); return
 * electionResultService.viewCandidatewiseResult(candidateId); }
 * 
 * @GetMapping(path="view/voting/percentage") public double
 * viewVotingPercentage() { log.info("Voting percentage viewed.."); return
 * electionResultService.viewVotingPercentage(); }
 * 
 * @GetMapping(path="view/candidate/{candidateId}") public double
 * viewCandidateVotingPercent(@PathVariable int candidateId) throws
 * CastedVoteNotFoundException {
 * log.info("Election result viewed via candidate.."); return
 * electionResultService.viewCandidateVotingPercent( candidateId) ; }
 * 
 * @GetMapping(path="view/highest/percent") public NominatedCandidates
 * viewHighestVotingPercentCandidate() throws CastedVoteNotFoundException {
 * log.info("Highest percentage secured viewed.."); return
 * electionResultService.viewHighestVotingPercentCandidate(); }
 * 
 * @GetMapping(path="view/lowest/percent") public NominatedCandidates
 * viewLowestVotingPercentCandidate() throws CastedVoteNotFoundException {
 * log.info("Lowest percentage secured viewed.."); return
 * electionResultService.viewLowestVotingPercentCandidate(); }
 * 
 * @GetMapping(path = "display/stats") public HashMap<String, Integer>
 * displayVotingStatistics() { log.info("Hashmap displayed.."); return
 * electionResultService.displayVotingStatistics(); }
 * 
 * @GetMapping(path = "display/pollResult") public HashMap<String, Double>
 * displayPollingResult() { log.info("Poll Result.."); return
 * electionResultService.displayPollingResult(); }
 * 
 * 
 * }
 */