// 8 November: Suyog's Code
package org.society.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="electionresult_table")
public class ElectionResult {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date pollingDate;
	
	/*7 November */
	@JsonManagedReference
	@OneToMany(mappedBy = "electionResult", cascade = CascadeType.ALL)
	private List<NominatedCandidates> candidate;
	
	// 10 November changed
	private String societyName;
	private int totalSocietyVotes;
	private int totalPolledVotes;
	private float totalPollingPercentage;
	private int totalCandidateVotes;
	private float candidateVotesPercentage;
	private String result;

	public ElectionResult() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPollingDate() {
		return pollingDate;
	}
	public void setPollingDate(Date pollingDate) {
		this.pollingDate = pollingDate;
	}
	
	public List<NominatedCandidates> getCandidate() {
		return candidate;
	}

	public void setCandidate(List<NominatedCandidates> candidate) {
		this.candidate = candidate;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public int getTotalSocietyVotes() {
		return totalSocietyVotes;
	}
	public void setTotalSocietyVotes(int totalSocietyVotes) {
		this.totalSocietyVotes = totalSocietyVotes;
	}
	public int getTotalPolledVotes() {
		return totalPolledVotes;
	}
	public void setTotalPolledVotes(int totalPolledVotes) {
		this.totalPolledVotes = totalPolledVotes;
	}
	public float getTotalPollingPercentage() {
		return totalPollingPercentage;
	}
	public void setTotalPollingPercentage(float totalPollingPercentage) {
		this.totalPollingPercentage = totalPollingPercentage;
	}
	public int getTotalCandidateVotes() {
		return totalCandidateVotes;
	}
	public void setTotalCandidateVotes(int totalCandidateVotes) {
		this.totalCandidateVotes = totalCandidateVotes;
	}
	public float getCandidateVotesPercentage() {
		return candidateVotesPercentage;
	}
	public void setCandidateVotesPercentage(float candidateVotesPercentage) {
		this.candidateVotesPercentage = candidateVotesPercentage;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	}