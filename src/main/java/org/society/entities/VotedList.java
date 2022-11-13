package org.society.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="votedlist_table")
public class VotedList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/*5 November*/
	private Date pollingDateTime;
	
	@ManyToOne
	private CooperativeSociety society;
	// 7 November
	// Changed to MERGE as, detached entity type error  
	
	// 13 November
	/*
	 * @OneToOne(cascade = CascadeType.ALL) private RegisteredSocietyVoters voter;
	 * 
	 * @ManyToOne private NominatedCandidates candidate;
	 */
	
	// 13 November
	private int societyId;
	private int voterId;
	private int candidateId;
	
	
	public int getSocietyId() {
		return societyId;
	}

	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public VotedList() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPollingDateTime() {
		return pollingDateTime;
	}

	public void setPollingDateTime(Date pollingDateTime) {
		this.pollingDateTime = pollingDateTime;
	}

	public CooperativeSociety getSociety() {
		return society;
	}

	public void setSociety(CooperativeSociety society) {
		this.society = society;
	}

//	public RegisteredSocietyVoters getVoter() {
//		return voter;
//	}
//
//	public void setVoter(RegisteredSocietyVoters voter) {
//		this.voter = voter;
//	}
//
//	public NominatedCandidates getCandidate() {
//		return candidate;
//	}
//
//	public void setCandidate(NominatedCandidates candidate) {
//		this.candidate = candidate;
//	}
}
