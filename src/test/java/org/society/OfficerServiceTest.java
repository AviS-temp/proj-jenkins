package org.society;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.society.dao.ElectionOfficerDao;
import org.society.dao.UserDao;
import org.society.entities.ElectionOfficer;
import org.society.exceptions.ElectionOfficerAlreadyExistsException;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.society.repository.ElectionOfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OfficerServiceTest {
	
	@MockBean
	private ElectionOfficerRepository officerRepo;
	
	@Autowired
	private ElectionOfficerDao service;
	
	private ElectionOfficer officer;
	
//	@BeforeEach
//	public void setup()
//	{
//		ElectionOfficer officer = new ElectionOfficer();
//		officer.setFirstName("Alok");
//		officer.setLastName("Kumar");
//		officer.setEmailId("alok@gmail.com");
//		officer.setGender("Male");
//		officer.setOfficerId(101);
//		officer.setPassword("AK");
//		officer.setPincode(651232);
//		officer.setMobileno("9090909011");
//		officer.setDistrict("Sundargarh");
//		officer.setAddress1("Address1");
//		officer.setAddress2("Address2");
//	}
//	
	@Test
	public void viewByIdTest() throws ElectionOfficerNotFoundException
	{
		ElectionOfficer officer = new ElectionOfficer();
		officer.setFirstName("Alok");
		officer.setLastName("Kumar");
		officer.setEmailId("alok@gmail.com");
		officer.setGender("Male");
		officer.setOfficerId(101);
		officer.setPassword("AK");
		officer.setPincode(651232);
		officer.setMobileno("9090909011");
		officer.setDistrict("Sundargarh");
		officer.setAddress1("Address1");
		officer.setAddress2("Address2");
		
		when(officerRepo.findById(101)).thenReturn(Optional.of(officer)).thenReturn(null);
		assertEquals(officer,service.viewElectionOfficerById(101));
	}
	
	@Test
	public void testOfficerlist()
	{
		ElectionOfficer officer = new ElectionOfficer();
		officer.setFirstName("Alok");
		officer.setLastName("Kumar");
		officer.setEmailId("alok@gmail.com");
		officer.setGender("Male");
		officer.setOfficerId(101);
		officer.setPassword("AK");
		officer.setPincode(651232);
		officer.setMobileno("9090909011");
		officer.setDistrict("Sundargarh");
		officer.setAddress1("Address1");
		officer.setAddress2("Address2");
		
		ElectionOfficer officer1 = new ElectionOfficer();
		officer1.setFirstName("Ananya");
		officer1.setLastName("Kumari");
		officer1.setEmailId("bv@gmail.com");
		officer1.setGender("Female");
		officer1.setOfficerId(102);
		officer1.setPassword("BV");
		officer1.setPincode(651232);
		officer1.setMobileno("7770909011");
		officer1.setDistrict("Khurda");
		officer1.setAddress1("Address1");
		officer1.setAddress2("Address2");
		
		when(officerRepo.findAll()).thenReturn(Stream.of(officer,officer1).collect(Collectors.toList()));
		assertEquals(2,service.viewElectionOfficerList().size());
	}
	
	@Test
	public void testByEmailandPwd()
	{
		ElectionOfficer officer1 = new ElectionOfficer();
		officer1.setFirstName("Ananya");
		officer1.setLastName("Kumari");
		officer1.setEmailId("bv@gmail.com");
		officer1.setGender("Female");
		officer1.setOfficerId(102);
		officer1.setPassword("BV");
		officer1.setPincode(651232);
		officer1.setMobileno("7770909011");
		officer1.setDistrict("Khurda");
		officer1.setAddress1("Address1");
		officer1.setAddress2("Address2");
		
		when(officerRepo.findByEmailIdAndPassword("bv@gmail.com", "BV")).thenReturn(officer1);
		assertEquals(officer1,service.findByEmailandPwd("bv@gmail.com", "BV"));
	}
	
	@Test
	public void testByEmail()
	{
		ElectionOfficer officer1 = new ElectionOfficer();
		officer1.setFirstName("Ananya");
		officer1.setLastName("Kumari");
		officer1.setEmailId("bv@gmail.com");
		officer1.setGender("Female");
		officer1.setOfficerId(102);
		officer1.setPassword("BV");
		officer1.setPincode(651232);
		officer1.setMobileno("7770909011");
		officer1.setDistrict("Khurda");
		officer1.setAddress1("Address1");
		officer1.setAddress2("Address2");
		
		when(officerRepo.findByEmailId("bv@gmail.com")).thenReturn(officer1);
		assertEquals(officer1,service.findByEmail("bv@gmail.com"));
	}
	
	@Test
	public void addOfficerTest() throws ElectionOfficerAlreadyExistsException
	{
		ElectionOfficer officer1 = new ElectionOfficer();
		 when(officerRepo.save(officer1)).thenReturn(officer1).thenReturn(null);
		 assertEquals(1,service.addElectionOfficerDetails(officer1));
	}

}
