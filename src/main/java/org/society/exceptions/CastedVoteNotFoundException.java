package org.society.exceptions;

public class CastedVoteNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public CastedVoteNotFoundException(String msg)
	{
		super(msg);
	}

}
