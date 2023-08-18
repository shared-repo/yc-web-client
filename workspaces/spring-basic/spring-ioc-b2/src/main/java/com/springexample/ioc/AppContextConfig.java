package com.springexample.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Setter;

@Configuration // app-context.xml과 같이 bean 설정을 수행하는 클래스로 지정
public class AppContextConfig implements ApplicationContextAware {
	
	@Bean 
	public MyServiceConsumer serviceConsumer() {
		MyServiceConsumer serviceConsumer = new MyServiceConsumer();
		
		MessageService messageService = applicationContext.getBean(MessageService.class);
		serviceConsumer.setMessageService( messageService ); 
		TimeService timeService = applicationContext.getBean(TimeService.class);
		serviceConsumer.setTimeService( timeService );
		return serviceConsumer;
	}
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	
	
	
}


