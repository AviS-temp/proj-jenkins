package org.society;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.society.dao.CooperativeSocietyDao;
import org.society.entities.CooperativeSociety;
import org.society.exceptions.CooperativeSocietyAlreadyExistsException;
import org.society.exceptions.CooperativeSocietyNotFoundException;
import org.society.repository.CooperativeSocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SocietyServiceTest {
	
	@MockBean
	private CooperativeSocietyRepository coopRepo;
	
	@Autowired
	private CooperativeSocietyDao service;
	
	@Test
	public void addSocietyTest() throws CooperativeSocietyAlreadyExistsException
	{
		CooperativeSociety coop = new CooperativeSociety();
		when(coopRepo.save(coop)).thenReturn(coop);
		assertEquals(coop,service.addSocietyDetails(coop));
	}
	@Test
	public void getSocietiesTest() throws CooperativeSocietyNotFoundException
	{
		CooperativeSociety coop1 = new CooperativeSociety();
		CooperativeSociety coop2 = new CooperativeSociety();
		CooperativeSociety coop3 = new CooperativeSociety();
		CooperativeSociety coop4 = new CooperativeSociety();
		when(coopRepo.findAll()).thenReturn(Stream.of(coop1,coop2,coop3,coop4).collect(Collectors.toList()));
		assertEquals(4,service.viewSocietiesList().size());
	}
	
	@Test
	public void getSocietyTest() throws CooperativeSocietyNotFoundException
	{
		CooperativeSociety coop1 = new CooperativeSociety();
		coop1.setSocietyId(101);
		when(coopRepo.findById(101)).thenReturn(Optional.of(coop1));
		assertEquals(coop1,service.viewSocietyById(101));
	}
	

}
