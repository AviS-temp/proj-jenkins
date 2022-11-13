package org.society.exceptions;

public class ElectionOfficerNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ElectionOfficerNotFoundException(String msg)
	{
		super(msg);
	}

}
