// November 10 - Saurabh's Code
package org.society.dao;

import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.exceptions.CooperativeSocietyAlreadyExistsException;
import org.society.exceptions.CooperativeSocietyNotFoundException;
import org.society.repository.CooperativeSocietyRepository;
import org.society.service.CooperativeSocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CooperativeSocietyDao implements CooperativeSocietyService {

	@Autowired
	private CooperativeSocietyRepository coopRepo;

	@Override
	/* 5 November: changed return type */
	public CooperativeSociety addSocietyDetails(@RequestBody CooperativeSociety society)
			throws CooperativeSocietyAlreadyExistsException {
		// 9Nov
		CooperativeSociety cs = coopRepo.findBySocietyName(society.getSocietyName());
		if (cs != null) {
			throw new CooperativeSocietyAlreadyExistsException("Society already exists.");
		} else {
			return coopRepo.save(society);
		}

	}
	
	// For updating purposes
	public CooperativeSociety addUpdSocietyDetails(@RequestBody CooperativeSociety society)
	{
		return coopRepo.save(society);
	}

	@Override
	/* November 5 - Changed return type */
	public CooperativeSociety updateSocietyDetails(CooperativeSociety society)
			throws CooperativeSocietyNotFoundException {
		// 9Nov
		CooperativeSociety cs = coopRepo.findBySocietyName(society.getSocietyName());
		if (cs == null) {
			throw new CooperativeSocietyNotFoundException("Society not found");
		} else {
			return coopRepo.save(society);

		}

	}

	@Override
	/* November 5 - Changed Return Type */
	public void deleteSociety(int societyId) throws CooperativeSocietyNotFoundException {
		// 9Nov
		CooperativeSociety cs = coopRepo.findById(societyId).get();
		if (cs == null) {
			throw new CooperativeSocietyNotFoundException("Society not found");
		} else {
			coopRepo.deleteById(societyId);
		}

	}

	@Override
	/* November 5 */
	public List<CooperativeSociety> viewSocietiesList() throws CooperativeSocietyNotFoundException {
		// 9Nov
		List<CooperativeSociety> csList = coopRepo.findAll();
		if (csList.isEmpty()) {
			throw new CooperativeSocietyNotFoundException("No society present.");
		} else {
			return csList;
		}

	}

	@Override
	public CooperativeSociety viewSocietyById(int societyId) throws CooperativeSocietyNotFoundException {
		// 9Nov
		CooperativeSociety cs = coopRepo.findById(societyId).get();
		if (cs == null) {
			throw new CooperativeSocietyNotFoundException("Society not found");
		} else {
			return coopRepo.findById(societyId).get();
		}
	}

}
