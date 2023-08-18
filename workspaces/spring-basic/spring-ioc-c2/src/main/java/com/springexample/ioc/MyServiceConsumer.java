package com.springexample.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component("serviceConsumer")
public class MyServiceConsumer implements ServiceConsumer {

	private MessageService messageService;
	private TimeService timeService;
	
	@Autowired // 필드, 세터메서드, 생성자 전달인자에 각각 사용 가능
	@Qualifier("messageService")
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	@Autowired
	@Qualifier("timeService")
	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}

	public void doSomething() {
		
		System.out.println("MyServiceConsumer.doSomething() is called !!!");
		
		String message = messageService.getMessage();
		System.out.println(message);
		
		String timeString = timeService.getTimeString();
		System.out.println(timeString);
		
		
	}





}








