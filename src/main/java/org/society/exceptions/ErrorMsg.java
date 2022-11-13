package org.society.exceptions;
import java.time.LocalDateTime;


public class ErrorMsg {
	private LocalDateTime date;
	private String errorMsg;
	
	public ErrorMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMsg(LocalDateTime date, String errorMsg) {
		super();
		this.date = date;
		this.errorMsg = errorMsg;
	}
	public ErrorMsg(LocalDateTime date, String errorMsg, String validationMsg) {
		super();
		this.date = date;
		this.errorMsg = errorMsg;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	

}