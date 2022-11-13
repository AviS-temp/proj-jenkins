package org.society.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="cooperativesociety_table")
public class CooperativeSociety {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int societyId;
	private String societyName;
	private String headOfSociety;
	private String village;
	/*5 November*/
	//private String mandal;
	private String district;
	private String pincode;
	
	/*5th November*/
	@OneToMany(mappedBy="society", cascade=CascadeType.ALL)
	List<RegisteredSocietyVoters> registeredSocietyVoters = new ArrayList<>();
	
	/*7th November*/
	@OneToMany(mappedBy="society", cascade = CascadeType.ALL)
	List<VotedList> votedList = new ArrayList<>();
	
	
	
	
	public CooperativeSociety() {
		super();
	}


	public int getSocietyId() {
		return societyId;
	}


	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}


	public String getSocietyName() {
		return societyName;
	}


	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}


	public String getHeadOfSociety() {
		return headOfSociety;
	}


	public void setHeadOfSociety(String headOfSociety) {
		this.headOfSociety = headOfSociety;
	}


	public String getVillage() {
		return village;
	}


	public void setVillage(String village) {
		this.village = village;
	}


	/*
	 * public String getMandal() { return mandal; }
	 * 
	 * 
	 * public void setMandal(String mandal) { this.mandal = mandal; }
	 */


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
