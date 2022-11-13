package org.society.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.dao.RegisteredSocietyVotersDao;
import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.RegisteredSocietyVotersAlreadyExistsException;
import org.society.exceptions.RegisteredSocietyVotersNotFoundException;
import org.society.exceptions.VoterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@CrossOrigin("*")
public class RegisteredSocietyVotersController {
	
	@Autowired
	private RegisteredSocietyVotersDao regDao;
	
	// 11 November - Adding Loggers
		Logger log=LoggerFactory.getLogger(RegisteredSocietyVotersController.class);
	
	/*November 5 */
	@PostMapping("/add")
	public RegisteredSocietyVoters addRegistration(@RequestBody RegisteredSocietyVoters voter) throws RegisteredSocietyVotersAlreadyExistsException
	{
		log.info("Voter registered !!");
		return regDao.voterRegistration(voter);
	}
	
	/*November 5 */
	@GetMapping("/get/{voterIdCardNo}")
	public RegisteredSocietyVoters getRegistration(@PathVariable String voterIdCardNo) throws RegisteredSocietyVotersNotFoundException
	{
		log.info("Voter fetched through VoterId !!");
		return regDao.searchByVoterID(voterIdCardNo);
	}
	
	/*November 5 */
	@DeleteMapping("/delete/{voterIdCardNo}")
	public void deleteByVoterIdCard(@PathVariable String voterIdCardNo) throws RegisteredSocietyVotersNotFoundException
	{
		log.info("Voter deleted !!");
		regDao.deleteRegisteredVoter(voterIdCardNo);
	}
	
	/*November 5 */
	@GetMapping("/getAll")
	public List<RegisteredSocietyVoters> getAllVoters() throws RegisteredSocietyVotersNotFoundException
	{
		log.info("Voter list viewed !!");
		return regDao.viewRegisteredVoterList();
	}
	
	/*November 5*/
	@PutMapping("/update/{voterIdCardNo}")
	public RegisteredSocietyVoters updateVoter(@PathVariable String voterIdCardNo,@RequestBody RegisteredSocietyVoters voter) throws RegisteredSocietyVotersNotFoundException
	{
		RegisteredSocietyVoters VOTER = regDao.searchByVoterID(voterIdCardNo);
		if(VOTER != null)
		{
			VOTER.setAddress1(voter.getAddress1());
			VOTER.setDistrict(voter.getDistrict());
			VOTER.setEmailId(voter.getEmailId());
			VOTER.setFirstName(voter.getFirstName());
			VOTER.setGender(voter.getLastName());
			VOTER.setLastName(voter.getLastName());
			VOTER.setMobileno(voter.getMobileno());
			VOTER.setPassword(voter.getPassword());
			// Not added VoterIdCardNo since it remains same
			RegisteredSocietyVoters updatedVOTER = regDao.voterUpdRegistration(VOTER); // 
			log.info("Voter details updated");
			return updatedVOTER;
		}
		else
		{
			log.info("Voter details not updated");
			return null;
		}
	}
	
	// 8 November
	@PostMapping("/login")																																	// 11 November
	public RegisteredSocietyVoters loginVoter(@RequestBody RegisteredSocietyVoters voter) throws VoterNotFoundException
	{
		String pwd = voter.getPassword();
		String voterId = voter.getVoterIdCardNo();
		RegisteredSocietyVoters existVoter = null;
		if(pwd!=null&voterId!=null)
		{
			log.info("Voter logged in");
			existVoter = regDao.findByPasswordandVoterIdCardNo(pwd,voterId);	
		}
		if(existVoter==null)
		{
			throw new VoterNotFoundException("Voter does not exist");
		}
		return existVoter;
	}
	
	// 9 November For Forget Password Purposes
	@GetMapping("/getByIDMail/{emailId}")
	public RegisteredSocietyVoters getVoter(@PathVariable String emailId)
	{
		RegisteredSocietyVoters voter = regDao.findByEmailId(emailId);
		String email = voter.getEmailId();
		String voterIdCardNo = voter.getVoterIdCardNo();
		log.info("Voter fetched through EmailId");
		return regDao.findByVoterIdCardNoAndEmailId(voterIdCardNo,email);
	}
	
	// 9 November
	@GetMapping("/voter/{voterIdCardNo}")
	public RegisteredSocietyVoters getVoterById(@PathVariable String voterIdCardNo) throws RegisteredSocietyVotersNotFoundException
	{
		log.info("Voter fetched through VoterIdCard");
		return regDao.searchByVoterID(voterIdCardNo);
	}
	

}
