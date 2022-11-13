package org.society.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.dao.ElectionOfficerDao;
import org.society.entities.ElectionOfficer;
import org.society.entities.User;
import org.society.exceptions.ElectionOfficerAlreadyExistsException;
import org.society.exceptions.ElectionOfficerNotFoundException;
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

/*5 November*/
/*Changes made to Khushal Code*/

@RestController
// added Request Mapping
@RequestMapping("/officer")
// 9 November
@CrossOrigin("*")
public class ElectionOfficerController {
	
	// Changed this code
	@Autowired
	private ElectionOfficerDao eDao;
	
	// 11 November - Adding Loggers
		Logger log=LoggerFactory.getLogger(ElectionOfficerController.class);
	
	@PostMapping("/add")
	public int addElectionOfficerDetails(@RequestBody ElectionOfficer officer) throws ElectionOfficerAlreadyExistsException
	{
		log.info("Officer added"); // Added Logger
		return eDao.addElectionOfficerDetails(officer);
	}
	
	// Needs To Be Changed
	@PutMapping(path = "/update")
	public int updateElectionOfficerDetails(@RequestBody ElectionOfficer officer) throws ElectionOfficerNotFoundException
	{
		log.info("Officer details updated"); // Added Logger
		return eDao.updateElectionOfficerDetails(officer);
	}
	
	@DeleteMapping(path = "/delete/{officerId}")
	public int deleteElectionOfficer(@PathVariable int officerId) throws ElectionOfficerNotFoundException
	{
		log.info("Officer deleted"); // Added Logger
		return eDao.deleteElectionOfficer(officerId);
	}
	
	@GetMapping(path = "/view/{officerId}")
	public ElectionOfficer viewElectionOfficerById(@PathVariable int officerId) throws ElectionOfficerNotFoundException
	{
		log.info("Officer viewed by Id"); // Added Logger
		return eDao.viewElectionOfficerById(officerId);
	}
	
	@GetMapping(path = "/viewAll")
	public List<ElectionOfficer> viewElectionOfficerList()
	{
		log.info("List of officers viewed"); // Added Logger
		return eDao.viewElectionOfficerList();
	}
	
	// November 9
	@PostMapping(path="/login")																				// 11 November
	public ElectionOfficer loginUser(@RequestBody ElectionOfficer officer) throws ElectionOfficerNotFoundException
	{
		String email = officer.getEmailId();
		String pwd = officer.getPassword();
		ElectionOfficer existOfficer= null;
		if(email!=null&&pwd!=null)
		{
			log.info("Officer logged in.."); // Added Logger
			existOfficer =eDao.findByEmailandPwd(email, pwd);	
		}
		if(existOfficer==null)
		{
			throw new ElectionOfficerNotFoundException("Officer does not exist");
		}
		return existOfficer;
	}
	
	// 9 November - For forget password purposes
	@GetMapping("/byEmail/{emailId}")
	public ElectionOfficer getOfficerByMail(@PathVariable String emailId)
	{
		log.info("Viewed officer via email"); // Added Logger
		return eDao.findByEmail(emailId);
	}
}
