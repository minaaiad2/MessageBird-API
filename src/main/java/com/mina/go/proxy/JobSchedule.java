package com.mina.go.proxy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.mina.go.beans.Message;
import com.mina.go.beans.MessageRegistration;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobSchedule {


	
    private static final Logger log = LoggerFactory.getLogger(JobSchedule.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
    	
        log.info("The time is now {}", dateFormat.format(new Date()));
        Message msg=MessageRegistration.getInstance().getMessageRecords().poll();
        if(msg!=null)
        {
        	log.info(msg.getMessage());
        	
        	//try to send message with messageBirdClient
        	boolean sent=MessageBirdProxy.getInstance().SendSMS(msg.getMessage(), msg.getRecipient());

        	//if failed put it again in the queueto try once again
          	if(!sent)
          		MessageRegistration.getInstance().getMessageRecords().add(msg);
        }
    }
}
