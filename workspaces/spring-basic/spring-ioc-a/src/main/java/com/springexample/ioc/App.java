package com.springexample.ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("app-context.xml");
		
		ServiceConsumer serviceConsumer = context.getBean("serviceConsumer", ServiceConsumer.class);
		serviceConsumer.doSomething();
		
		ServiceConsumer serviceConsumer2 = context.getBean("serviceConsumer", ServiceConsumer.class);
		serviceConsumer2.doSomething(); // singleton이면 위의 객체와 같은 번호 출력 prototype이면 다른 번호 출력
		
		context.close();

	}

}
