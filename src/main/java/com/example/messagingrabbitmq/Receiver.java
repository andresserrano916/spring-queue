package com.example.messagingrabbitmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver implements MessageListener {

	private CountDownLatch latch = new CountDownLatch(1);
	
	
	@Override
	public void onMessage(Message message) {
		System.out.println("Received <"+ new String(message.getBody()) + ">");
		latch.countDown();
		
	}
	
	public CountDownLatch getLatch(){
		return latch;
	}
}
