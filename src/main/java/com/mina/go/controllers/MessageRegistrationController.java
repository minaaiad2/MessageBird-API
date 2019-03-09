package com.mina.go.controllers;


import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mina.go.beans.*;


@Controller
public class MessageRegistrationController {

	

	  @RequestMapping(method = RequestMethod.POST, value="/register/message")
	  @ResponseBody
	  public MessageRegistrationReply registerMessage(@RequestBody Message message) {
		  	System.out.println("In registerMessage");
		  	MessageRegistrationReply msgregreply = new MessageRegistrationReply();           
		
	        //We are setting the below value just to reply a message back to the caller
	        msgregreply.setMessage(message.getMessage());
	        msgregreply.setOriginator(message.getOriginator());
	        msgregreply.setRecipient(message.getRecipient());
	        boolean valid=msgregreply.validate();
	        if(valid)
	        {
	        	msgregreply.setStatus("Sending in progress");
	          	MessageRegistration.getInstance().add(message);
	        }
	        
	        return msgregreply;
	}
}
