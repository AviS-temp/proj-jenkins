package org.society.service;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.RegisteredSocietyVotersAlreadyExistsException;
import org.society.exceptions.RegisteredSocietyVotersNotFoundException;

/*5 November Changed title*/
public interface RegisteredSocietyVotersService {
	/*5 November changed return type*/
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter) throws RegisteredSocietyVotersAlreadyExistsException;
	/*November 5 - Changed Return Type from int to RegisteredSocietyVoters */
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) throws RegisteredSocietyVotersNotFoundException;
	/*November 5*/
	/*Changed return type from int to void*/
	/*Changed parameter type from int to String*/
	public void deleteRegisteredVoter(String voterId) throws RegisteredSocietyVotersNotFoundException;
	/*November 5*/
	public List<RegisteredSocietyVoters> viewRegisteredVoterList() throws RegisteredSocietyVotersNotFoundException;
	/*November 5 - Changed parameter type*/
	public RegisteredSocietyVoters searchByVoterID(String voterIdCardNo) throws RegisteredSocietyVotersNotFoundException;
	
	// Pending For Later
	public RegisteredSocietyVoters loginValidate(String userid,String password) ;
}
