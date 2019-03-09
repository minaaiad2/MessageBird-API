package com.mina.go.controllers;

import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mina.go.beans.MessageRegistration;
import com.mina.go.beans.*;
@Controller
public class MessageRetrieveController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/message/allmesages")
	@ResponseBody
	public Queue<Message> getAllMessages() {
		return MessageRegistration.getInstance().getMessageRecords();
	}
}
