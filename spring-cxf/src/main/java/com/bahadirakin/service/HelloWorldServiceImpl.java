package com.bahadirakin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bahadirakin.model.HelloWorldMessage;
import com.bahadirakin.model.Person;
import com.bahadirakin.producer.MessageProducer;

public class HelloWorldServiceImpl implements HelloWorldService {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldMessage.class);
     
	
	@Autowired
	private MessageProducer messageProducer;
	
	public HelloWorldServiceImpl() {
		
	}
	

	public HelloWorldServiceImpl(MessageProducer messageProducer) {
		super();
		logger.info("Hello world service is created");
		this.messageProducer = messageProducer;
	}

	public HelloWorldMessage sayHelloWorldTo(Person person) {
		logger.info("Saying hello world to {}", person);
		return messageProducer.produceHelloWorldMessage(person);
	}
}
