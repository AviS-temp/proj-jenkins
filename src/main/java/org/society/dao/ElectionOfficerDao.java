// November 10  - Saurabh's Code
package org.society.dao;

import java.util.List;

import org.society.entities.ElectionOfficer;
import org.society.exceptions.ElectionOfficerAlreadyExistsException;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.society.repository.ElectionOfficerRepository;
import org.society.service.ElectionOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*November 5 - Khushal*/
@Service
public class ElectionOfficerDao implements ElectionOfficerService {

	@Autowired
	private ElectionOfficerRepository repository;

	@Override
	/* November 5 */
	// No changes made to the return types or parameters
	public int addElectionOfficerDetails(ElectionOfficer officer) throws ElectionOfficerAlreadyExistsException {
		// 9Nov
		ElectionOfficer eo = repository.findByEmailId(officer.getEmailId());
		if (eo != null) {
			throw new ElectionOfficerAlreadyExistsException("Election Officer already present.");
		} else {
			repository.save(officer);
			return 1;
		}

	}

	@Override
	/* November 5 */
	// No changes made to the return types or parameters
	public int updateElectionOfficerDetails(ElectionOfficer officer) throws ElectionOfficerNotFoundException {
		// 9Nov
		ElectionOfficer eo = repository.findByEmailId(officer.getEmailId());
		if (eo == null) {
			throw new ElectionOfficerNotFoundException("Election officer doesn't exists.");
		} else {
			repository.save(officer);
			return 1;
		}

	}

	@Override
	/* November 5 */
	// No changes made to the return types or parameters
	public int deleteElectionOfficer(int officerId) throws ElectionOfficerNotFoundException {
		// 9Nov
		ElectionOfficer eo = repository.findById(officerId).get();
		if (eo == null) {
			throw new ElectionOfficerNotFoundException("Election officer doesn't exists.");
		} else {
			repository.deleteById(officerId);
			return 1;
		}
	}

	@Override
	/* November 5 */
	// No changes made to the return types or parameters
	public ElectionOfficer viewElectionOfficerById(int officerId) throws ElectionOfficerNotFoundException {
		// 9Nov
		ElectionOfficer eo = repository.findById(officerId).get();
		if (eo == null) {
			throw new ElectionOfficerNotFoundException("Election officer doesn't exists.");
		} else {
			return eo;
		}
	}

	@Override
	/* November 5 */
	// No changes made to the return types or parameters
	public List<ElectionOfficer> viewElectionOfficerList() {
		// 9Nov
		List<ElectionOfficer> electionOfficerList = repository.findAll();
		return electionOfficerList;
	}

	// November 9
	public ElectionOfficer findByEmailandPwd(String email, String pwd) {
		return repository.findByEmailIdAndPassword(email, pwd);
	}

	public ElectionOfficer findByEmail(String emailId) {
		return repository.findByEmailId(emailId);
	}

}
