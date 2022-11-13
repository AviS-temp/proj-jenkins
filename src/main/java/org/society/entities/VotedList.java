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
	@OneToOne(cascade = CascadeType.ALL)
	private RegisteredSocietyVoters voter;
	@ManyToOne
	private NominatedCandidates candidate;
	
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

	public RegisteredSocietyVoters getVoter() {
		return voter;
	}

	public void setVoter(RegisteredSocietyVoters voter) {
		this.voter = voter;
	}

	public NominatedCandidates getCandidate() {
		return candidate;
	}

	public void setCandidate(NominatedCandidates candidate) {
		this.candidate = candidate;
	}
}
