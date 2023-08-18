package com.springexample.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
//		AnnotationConfigApplicationContext context = 
//				new AnnotationConfigApplicationContext(AppContextConfig.class, AppContextConfig2.class);
//		AnnotationConfigApplicationContext context = 
//				new AnnotationConfigApplicationContext(AppContextConfig3.class);
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppContextConfig4.class, AppContextConfig2.class);
		
		ServiceConsumer serviceConsumer = context.getBean("serviceConsumer", ServiceConsumer.class);
		serviceConsumer.doSomething();
		
		context.close();

	}

}
