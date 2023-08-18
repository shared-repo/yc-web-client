package com.springexample.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serviceConsumer")
public class MyServiceConsumer implements ServiceConsumer {

	@Autowired
	private MessageService messageService;
	
	@Autowired // 1. 호환 가능한 자료형의 bean 찾기 -> 2. timeService 이름의 bean 찾기
	@Qualifier("timeService1") // timeService1 이름의 bean 찾기
	private TimeService timeService;
	
	public void doSomething() {
		
		System.out.println("MyServiceConsumer.doSomething() is called !!!");
		
//		// 1. IoC 컨테이너를 직접 사용해서 객체를 찾고 사용
		// 컨테이너 만들기
//		GenericXmlApplicationContext context = new GenericXmlApplicationContext("app-context.xml");	
		
//		// MyMessageService 사용
//		MessageService messageService = context.getBean("messageService", MessageService.class);
//		String message = messageService.getMessage();
//		System.out.println(message);
//		
//		// MyTimeService 사용
//		TimeService timeService = context.getBean("timeService", TimeService.class);
//		String timeString = timeService.getTimeString();
//		System.out.println(timeString);
//		
//		context.close();
		
		// 2. IoC 컨테이너의 의존 주입 기능 적용 ( 직접 new 또는 getBean 할 필요 없음 )
		
		String message = messageService.getMessage();
		System.out.println(message);
		
		String timeString = timeService.getTimeString();
		System.out.println(timeString);
		
	}





}








