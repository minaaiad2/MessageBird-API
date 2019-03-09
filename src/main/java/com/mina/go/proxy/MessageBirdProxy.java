package com.mina.go.proxy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.messagebird.MessageBirdClient;
import com.messagebird.MessageBirdService;
import com.messagebird.MessageBirdServiceImpl;
import com.messagebird.exceptions.GeneralException;
import com.messagebird.exceptions.UnauthorizedException;
import com.messagebird.objects.Balance;
import com.messagebird.objects.MessageResponse;

public class MessageBirdProxy {


	final MessageBirdService messageBirdService ;

	final MessageBirdClient messageBirdClient ;
	
	private static MessageBirdProxy msgProxy=null;
	
	private MessageBirdProxy()
	{
		messageBirdService = new MessageBirdServiceImpl("test_gshuPaZoeEG6ovbc8M79w0QyM");
		 messageBirdClient = new MessageBirdClient(messageBirdService);
	}
	
	public static MessageBirdProxy getInstance()
	{
		if(msgProxy==null)
			msgProxy=new MessageBirdProxy();
		
		return msgProxy;
	}
	
	public Boolean SendSMS(String body,String phoneNum )
	{
	   try {
	        // send sms
		   final List<BigInteger> phones = new ArrayList<>();
		   phones.add(new BigInteger(phoneNum));
		   
	        System.out.println("sending SMS :");
            final MessageResponse response = messageBirdClient.sendMessage("MessageBird",body, phones);
            //Display message response
            System.out.println(response.toString());
            return true;

	   } catch (UnauthorizedException | GeneralException exception) {
           if (exception.getErrors() != null) {
               System.out.println(exception.getErrors().toString());
           }
           exception.printStackTrace();
           return false;
       }
	   
	}
	   
	   
}

