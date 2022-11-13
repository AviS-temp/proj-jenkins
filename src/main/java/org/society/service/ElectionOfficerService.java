package org.society.service;

import java.util.List;

import org.society.entities.ElectionOfficer;
import org.society.exceptions.ElectionOfficerAlreadyExistsException;
import org.society.exceptions.ElectionOfficerNotFoundException;

public interface ElectionOfficerService {												// Nov 10
	public int addElectionOfficerDetails(ElectionOfficer officer) throws ElectionOfficerAlreadyExistsException;
	public int updateElectionOfficerDetails(ElectionOfficer officer) throws ElectionOfficerNotFoundException;
	public int deleteElectionOfficer(int officerId) throws ElectionOfficerNotFoundException;
	public ElectionOfficer viewElectionOfficerById(int officerId) throws ElectionOfficerNotFoundException;
	/* Changes made on 5th November */
	// Again added back
	public List<ElectionOfficer> viewElectionOfficerList();
}
