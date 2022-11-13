package org.society.entities;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="registeredsocietyvoters_table")
public class RegisteredSocietyVoters {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//November 8
	// Adding this generator
	private String voterIdCardNo;
	private String firstName;
	private String lastName;
	private String password;
	private String gender;
	/* Changes on 5th November */
	// private String reservationCategory;
	private String mobileno;
	private String emailId;
	private String address1;
	/* Changes on 5th November */
	// private String address2;
	// private String mandal;   
	private String district;
	private int pincode;
	
	/*5 November*/
	@ManyToOne
	private CooperativeSociety society;
	
	/*5 November */
	/*
	 * @ManyToOne private NominatedCandidates nominatedCandidates;
	 */
	
	/*7 November*/
	//@JsonBackReference // Nov 10 - Added For Cyclic error
	
	// 12 November
	/*
	 * @OneToOne(cascade = CascadeType.ALL) private NominatedCandidates
	 * nominatedCandidates;
	 */
	//private int nominatedCandidates;
	
	// 7 November
	
	// 13 November
//	@OneToOne(cascade = CascadeType.ALL)
//	private VotedList votedList;
	
	private boolean castedVote;
	
	public RegisteredSocietyVoters() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoterIdCardNo() {
		return voterIdCardNo;
	}
	
	

	// 9 November
	// Changes made to check // Did not work
	

	public void setVoterIdCardNo(String voterIdCardNo) {
		this.voterIdCardNo = voterIdCardNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * public String getReservationCategory() { return reservationCategory; }
	 * 
	 * public void setReservationCategory(String reservationCategory) {
	 * this.reservationCategory = reservationCategory; }
	 */

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/*
	 * public String getAddress2() { return address2; }
	 * 
	 * public void setAddress2(String address2) { this.address2 = address2; }
	 */

	/*
	 * public String getMandal() { return mandal; }
	 * 
	 * public void setMandal(String mandal) { this.mandal = mandal; }
	 */
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public CooperativeSociety getSociety() {
		return society;
	}

	public void setSociety(CooperativeSociety society) {
		this.society = society;
	}

	public boolean isCastedVote() {
		return castedVote;
	}

	public void setCastedVote(boolean castedVote) {
		this.castedVote = castedVote;
	}

	// 12 November
	/*
	 * public NominatedCandidates getNominatedCandidates() { return
	 * nominatedCandidates; }
	 * 
	 * public void setNominatedCandidates(NominatedCandidates nominatedCandidates) {
	 * this.nominatedCandidates = nominatedCandidates; }
	 */
	
	// 13 November
//	public VotedList getVotedList() {
//		return votedList;
//	}
//
//	public void setVotedList(VotedList votedList) {
//		this.votedList = votedList;
//	}
	
	
	
}
