package com.springexample.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.Setter;

public class MyServiceConsumer implements ServiceConsumer {

	@Setter
	private MessageService messageService;
	@Setter
	private TimeService timeService;
	
	public void doSomething() {
		
		System.out.println("MyServiceConsumer.doSomething() is called !!!");
		
		String message = messageService.getMessage();
		System.out.println(message);
		
		String timeString = timeService.getTimeString();
		System.out.println(timeString);
		
		
	}





}








