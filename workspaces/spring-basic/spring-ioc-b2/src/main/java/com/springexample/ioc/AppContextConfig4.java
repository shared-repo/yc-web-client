package com.springexample.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Setter;

@Configuration // app-context.xml과 같이 bean 설정을 수행하는 클래스로 지정
public class AppContextConfig4 {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private TimeService timeService;
	
	@Bean 
	public MyServiceConsumer serviceConsumer() {
		MyServiceConsumer serviceConsumer = new MyServiceConsumer();
		
		serviceConsumer.setMessageService( messageService ); 
		serviceConsumer.setTimeService( timeService );
		return serviceConsumer;
	}
	
}


