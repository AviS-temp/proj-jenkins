package org.society.globalHandler;

import java.time.LocalDateTime;


import org.society.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CastedVoteNotFoundException.class)
	public ResponseEntity<Object> CastedVoteNotFoundException(CastedVoteNotFoundException castedVoteNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), castedVoteNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(CooperativeSocietyAlreadyExistsException.class)
	public ResponseEntity<Object> CooperativeSocietyAlreadyExistsException(CooperativeSocietyAlreadyExistsException cooperativeSocietyAlreadyExistsException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), cooperativeSocietyAlreadyExistsException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(CooperativeSocietyNotFoundException.class)
	public ResponseEntity<Object> CooperativeSocietyNotFoundException(CooperativeSocietyNotFoundException cooperativeSocietyNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), cooperativeSocietyNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(ElectionOfficerNotFoundException.class)
	public ResponseEntity<Object> ElectionOfficerNotFoundException(ElectionOfficerNotFoundException electionOfficerNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), electionOfficerNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(ElectionOfficerAlreadyExistsException.class)
	public ResponseEntity<Object> ElectionOfficerAlreadyExistsException(ElectionOfficerAlreadyExistsException electionOfficerAlreadyExistsException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), electionOfficerAlreadyExistsException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(ElectionResultAlreadyExistsException.class)
	public ResponseEntity<Object> ElectionResultAlreadyExistsException(ElectionResultAlreadyExistsException electionResultAlreadyExistsException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), electionResultAlreadyExistsException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(ElectionResultNotFoundException.class)
	public ResponseEntity<Object> ElectionResultNotFoundException(ElectionResultNotFoundException electionResultNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), electionResultNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(NominatedCandidateNotFoundException.class)
	public ResponseEntity<Object> NomindatedCandidateNotFoundException(NominatedCandidateNotFoundException nominatedCandidateNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), nominatedCandidateNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(NominatedCandidateAlreadyExistsException.class)
	public ResponseEntity<Object> NominatedCandidateAlreadyExistsException(NominatedCandidateAlreadyExistsException nominatedCandidateAlreadyExistsException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), nominatedCandidateAlreadyExistsException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(RegisteredSocietyVotersAlreadyExistsException.class)
	public ResponseEntity<Object> RegisteredSocietyVotersAlreadyExistsException(RegisteredSocietyVotersAlreadyExistsException registeredSocietyVotersAlreadyExistsException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), registeredSocietyVotersAlreadyExistsException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(RegisteredSocietyVotersNotFoundException.class)
	public ResponseEntity<Object> RegisteredSocietyVotersNotFoundException(RegisteredSocietyVotersNotFoundException registeredSocietyVotersNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), registeredSocietyVotersNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> UserNotFoundException(UserNotFoundException userNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), userNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> UserAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), userAlreadyExistsException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(VotedListAlreadyExistsException.class)
	public ResponseEntity<Object> VotedListAlreadyExistsException(VotedListAlreadyExistsException votedListAlreadyExistsException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), votedListAlreadyExistsException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(VotedListNotFoundException.class)
	public ResponseEntity<Object> VotedListNotFoundException(VotedListNotFoundException votedListNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), votedListNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	
	@ExceptionHandler(VoterNotFoundException.class)
	public ResponseEntity<Object> VoterNotFoundException(VoterNotFoundException voterNotFoundException)
	{
		ErrorMsg responseError=new ErrorMsg(LocalDateTime.now(), voterNotFoundException.getMessage());
		ResponseEntity< Object> res=new ResponseEntity<Object>(responseError, HttpStatus.BAD_REQUEST);
		return res;
	}
	

}
