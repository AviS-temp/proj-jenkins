package org.society.service;

import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.exceptions.CooperativeSocietyAlreadyExistsException;
import org.society.exceptions.CooperativeSocietyNotFoundException;

public interface CooperativeSocietyService {
	/*5 November Changed return type*/                // November 10
	public CooperativeSociety addSocietyDetails(CooperativeSociety society) throws CooperativeSocietyAlreadyExistsException;
	/*5 November Changed return type*/
	public CooperativeSociety updateSocietyDetails(CooperativeSociety society) throws CooperativeSocietyNotFoundException;
	/*5 November Changed return type*/
	public void deleteSociety(int societyId) throws CooperativeSocietyNotFoundException ;
	/*5 November*/
	public List<CooperativeSociety> viewSocietiesList() throws CooperativeSocietyNotFoundException;
	/*5 November*/
	public CooperativeSociety viewSocietyById(int societyId) throws CooperativeSocietyNotFoundException ;
}
