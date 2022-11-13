package org.society.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="nominatedcandidates_table")
public class NominatedCandidates {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int candidateId;
	private String nominationFormNo;
	
	/*7 November*/
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "nominatedCandidates")
	private RegisteredSocietyVoters society_Voter ;
	
	/*7 November*/
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	private ElectionResult electionResult;
	
	/*5 November*/
	@OneToMany(mappedBy="candidate",cascade = CascadeType.ALL)
	List<VotedList> votedList = new ArrayList<>();
	
	public NominatedCandidates() {
		super();
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getNominationFormNo() {
		return nominationFormNo;
	}

	public void setNominationFormNo(String nominationFormNo) {
		this.nominationFormNo = nominationFormNo;
	}

	

	public RegisteredSocietyVoters getSociety_Voter() {
		return society_Voter;
	}

	public void setSociety_Voter(RegisteredSocietyVoters society_Voter) {
		this.society_Voter = society_Voter;
	}

	public ElectionResult getElectionResult() {
		return electionResult;
	}

	public void setElectionResult(ElectionResult electionResult) {
		this.electionResult = electionResult;
	}

	public List<VotedList> getVotedList() {
		return votedList;
	}

	public void setVotedList(List<VotedList> votedList) {
		this.votedList = votedList;
	}


	
}