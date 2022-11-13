package org.society;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.society.dao.RegisteredSocietyVotersDao;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.RegisteredSocietyVotersAlreadyExistsException;
import org.society.exceptions.RegisteredSocietyVotersNotFoundException;

import org.society.repository.RegisteredSocietyVotersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class VotersServiceTest {
	
	@MockBean
	private RegisteredSocietyVotersRepository regRepo;
	
	@Autowired
	private RegisteredSocietyVotersDao service;
	
	private  RegisteredSocietyVoters voter;
	
	@Test
	public void testSaveVoter() throws RegisteredSocietyVotersAlreadyExistsException
	{
		RegisteredSocietyVoters voter = new RegisteredSocietyVoters();
		 when(regRepo.save(voter)).thenReturn(voter).thenReturn(null);
		 assertEquals(voter,service.voterRegistration(voter));
	}
	
	@Test
	public void testgetAllVoters() throws RegisteredSocietyVotersNotFoundException
	{
		when (regRepo.findAll()).thenReturn(Stream.of(voter).collect(Collectors.toList()));
		assertEquals(1,service.viewRegisteredVoterList().size());
	}
	
	@Test
	public void testVoterByIdAndPassword()
	{
		RegisteredSocietyVoters voter = new RegisteredSocietyVoters();
		voter.setVoterIdCardNo("ABSA933751");
		voter.setPassword("Avi");
		when(regRepo.findByPasswordAndVoterIdCardNo("ABSA933751","Avi")).thenReturn(voter);
		assertEquals(voter,service.findByPasswordandVoterIdCardNo("ABSA933751","Avi"));
	}
	
	@Test
	public void testByEmail()
	{
		RegisteredSocietyVoters voter1 = new RegisteredSocietyVoters();
		voter1.setEmailId("avi@gmail.com");
		when(regRepo.findByEmailId("avi@gmail.com")).thenReturn(voter1);
		assertEquals(voter1,service.findByEmailId("avi@gmail.com"));
	}
	
	

}
