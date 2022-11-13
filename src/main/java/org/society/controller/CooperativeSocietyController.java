package org.society.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.society.dao.CooperativeSocietyDao;
import org.society.entities.CooperativeSociety;
import org.society.exceptions.CooperativeSocietyAlreadyExistsException;
import org.society.exceptions.CooperativeSocietyNotFoundException;
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
@RestController
@RequestMapping("/coop")
@CrossOrigin("*")
public class CooperativeSocietyController {
	
	@Autowired
	private CooperativeSocietyDao coopDao;
	
	// 11 November - Adding Loggers
	Logger log=LoggerFactory.getLogger(CooperativeSocietyController.class);
	
	@PostMapping("/add")
	public CooperativeSociety addSociety(@RequestBody CooperativeSociety society) throws CooperativeSocietyAlreadyExistsException
	{
		log.info("New Society Created"); // LOGGER
		return coopDao.addSocietyDetails(society);
	}
	
	/*November 5*/
	@DeleteMapping("/delete/{id}")
	public void deleteSociety(@PathVariable int id) throws CooperativeSocietyNotFoundException
	{
		log.info("Society deleted"); // LOGGER
		coopDao.deleteSociety(id);	
	}
	
	/*November 5*/
	@GetMapping("/getAll")
	public List<CooperativeSociety> getAllSocieties() throws CooperativeSocietyNotFoundException
	{
		log.info("All societies viewed"); // LOGGER
		return coopDao.viewSocietiesList();
	}
	
	@GetMapping("/getById/{societyId}")
	public CooperativeSociety getSocietyById(@PathVariable int societyId) throws CooperativeSocietyNotFoundException
	{
		log.info("Fetched society by Id"); // LOGGER
		return coopDao.viewSocietyById(societyId);
	}
	
	/*November 5*/
	@PutMapping("/update/{societyId}")
	public CooperativeSociety updateSociety(@PathVariable int societyId, @RequestBody CooperativeSociety society) throws CooperativeSocietyNotFoundException
	{
		CooperativeSociety SOC = coopDao.viewSocietyById(societyId);
		if(SOC!=null)
		{
			SOC.setSocietyName(society.getSocietyName());
			SOC.setDistrict(society.getDistrict());
			SOC.setHeadOfSociety(society.getHeadOfSociety());
			SOC.setPincode(society.getPincode());
			SOC.setVillage(society.getVillage());
			CooperativeSociety updatedSOC = coopDao.addUpdSocietyDetails(SOC);
			log.info("Updated society"); // LOGGER
			return updatedSOC;
		}
		else
		{
			return null;
		}
		
	}

}
