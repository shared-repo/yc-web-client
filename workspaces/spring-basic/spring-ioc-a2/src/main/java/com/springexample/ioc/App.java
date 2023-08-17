package com.springexample.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);
		
		ServiceConsumer serviceConsumer = context.getBean("serviceConsumer", ServiceConsumer.class);
		serviceConsumer.doSomething();
		
		context.close();

	}

}
