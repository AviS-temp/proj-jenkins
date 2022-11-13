package org.society.dao;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.RegisteredSocietyVotersAlreadyExistsException;
import org.society.exceptions.RegisteredSocietyVotersNotFoundException;
import org.society.repository.RegisteredSocietyVotersRepository;
import org.society.service.RegisteredSocietyVotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredSocietyVotersDao implements RegisteredSocietyVotersService {

	@Autowired
	private RegisteredSocietyVotersRepository regRepo;

	@Override
	/* 5 November changed return type */
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter)
			throws RegisteredSocietyVotersAlreadyExistsException {
		// 9Nov
		RegisteredSocietyVoters rsv = regRepo.findByEmailId(voter.getEmailId());
		if (rsv != null) {
			throw new RegisteredSocietyVotersAlreadyExistsException("Voter already exists.");
		} else {
			return regRepo.save(voter);
		}
	}

	@Override
	/* November 5 - Changed Return Type */
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter)
			throws RegisteredSocietyVotersNotFoundException {
		// 9Nov
		RegisteredSocietyVoters rsv = regRepo.findByEmailId(voter.getEmailId());
		if (rsv == null) {
			throw new RegisteredSocietyVotersNotFoundException("Voter not found.");
		} else {
			return regRepo.save(voter);
		}
	}

	@Override
	/* 5 November Changed Return Type (int to void), renamed parameter as well */
	public void deleteRegisteredVoter(String voterIdCardNo) throws RegisteredSocietyVotersNotFoundException {
		// 9Nov
		RegisteredSocietyVoters rsv = regRepo.findByVoterIdCardNo(voterIdCardNo);
		if (rsv == null) {
			throw new RegisteredSocietyVotersNotFoundException("Voter not found.");
		} else {
			regRepo.deleteByVoterIdCardNo(voterIdCardNo);
		}

	}

	@Override
	/* November 5 */
	public List<RegisteredSocietyVoters> viewRegisteredVoterList() throws RegisteredSocietyVotersNotFoundException {
		// 9Nov
		List<RegisteredSocietyVoters> rsvList = regRepo.findAll();
		if (rsvList.isEmpty()) {
			throw new RegisteredSocietyVotersNotFoundException("No voters present.");
		} else {
			return rsvList;
		}
	}

	@Override
	/* November 5 - Changed return type */
	public RegisteredSocietyVoters searchByVoterID(String voterIdCardNo) throws RegisteredSocietyVotersNotFoundException {
		// 9Nov
		RegisteredSocietyVoters rsv = regRepo.findByVoterIdCardNo(voterIdCardNo);
		if (rsv == null) {
			throw new RegisteredSocietyVotersNotFoundException("Voter not found.");
		} else {
			return regRepo.findByVoterIdCardNo(voterIdCardNo);
		}
	}

	@Override
	public RegisteredSocietyVoters loginValidate(String userid, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	// 8 November
	public RegisteredSocietyVoters findByPasswordandVoterIdCardNo(String password, String voterIdCardNo) {
		return regRepo.findByPasswordAndVoterIdCardNo(password, voterIdCardNo);
	}

	// 9 November
	public RegisteredSocietyVoters findByVoterIdCardNoAndEmailId(String voterIdCardNo, String emailId) {
		// TODO Auto-generated method stub
		return regRepo.findByVoterIdCardNoAndEmailId(voterIdCardNo, emailId);
	}

	public RegisteredSocietyVoters findByEmailId(String emailId) {
		return regRepo.findByEmailId(emailId);
	}

	// 11 November - Added for Updating purposes
	public RegisteredSocietyVoters voterUpdRegistration(RegisteredSocietyVoters vOTER) {
		return regRepo.save(vOTER);
	}
	
	/*
	 * public List<String> getCandidates() { return regRepo.viewCandidates(); }
	 */

}
