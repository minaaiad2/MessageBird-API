package com.mina.go.beans;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageRegistration {

	private Queue<Message>  messageRecords;
	private static MessageRegistration msgregd=null;
	
	private MessageRegistration()
	{
		messageRecords=new ConcurrentLinkedQueue<Message>();
	}
	
	public static MessageRegistration getInstance()
	{
		
		if(msgregd==null)
		{
			msgregd=new MessageRegistration();
			return msgregd;
		}
		else
		{
			return msgregd;
		}
	}
	
	public Queue<Message>getMessageRecords()
	{
		return messageRecords;
	}
	
	public void add(Message msg)
	{
		messageRecords.add(msg);
	}
	
}
