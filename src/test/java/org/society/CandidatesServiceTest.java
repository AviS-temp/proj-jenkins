package org.society;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.society.dao.NominatedCandidatesDao;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateAlreadyExistsException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.repository.NominatedCandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CandidatesServiceTest {
	
	@MockBean
	private NominatedCandidatesRepository nomRepo;
	
	@Autowired
	private NominatedCandidatesDao service;
	
	@Test
	public void testSave() throws NominatedCandidateAlreadyExistsException
	{
		NominatedCandidates nc = new NominatedCandidates();
		when(nomRepo.save(nc)).thenReturn(nc);
		assertEquals(nc,service.addNominatedCandidate(nc));
	}
	
	@Test
	public void viewCandidatesTest() throws NominatedCandidateNotFoundException
	{
		NominatedCandidates nc1 = new NominatedCandidates();
		NominatedCandidates nc2 = new NominatedCandidates();
		when(nomRepo.findAll()).thenReturn(Stream.of(nc1,nc2).collect(Collectors.toList()));
		assertEquals(2,service.viewNominatedCandidatesList().size());
		
	}

	@Test
	public void getCandidateTest() throws NominatedCandidateNotFoundException 
	{
		NominatedCandidates nc1 = new NominatedCandidates();
		nc1.setCandidateId(102);
		when(nomRepo.findById(102)).thenReturn(Optional.of(nc1));
		assertEquals(nc1,service.searchByCandidateId(102));
		
	}
}
