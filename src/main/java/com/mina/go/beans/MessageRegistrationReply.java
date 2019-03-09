package com.mina.go.beans;

public class MessageRegistrationReply {

	
	
	String recipient;
	String originator;
	String message;
	String status;
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getOriginator() {
		return originator;
	}
	public void setOriginator(String originator) {
		this.originator = originator;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean validate()
	{
		if(message.length()>=160 )
		{
			this.status="message should be less than 160 character";
			return false;
		}
		else if(message==null || recipient==null || originator== null || message.isEmpty() || recipient.isEmpty() || originator.isEmpty())
		{
			status ="parameters shouldn't be empty  ";
			return false;
		}else if(!isNum(recipient ))
		{
			status ="recipient must be a valid number";
			return false;
		}
		else
			return true;
	}
	
	private boolean isNum(String num)
	{	try{
			Integer.parseInt(num);
			return true;
		} catch (Exception e) {
				return false;
		}
		
		
	}
}
