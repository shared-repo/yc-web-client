package com.springexample.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lombok.Setter;

@Configuration // app-context.xml과 같이 bean 설정을 수행하는 클래스로 지정
@Import(AppContextConfig2.class)
public class AppContextConfig3 {
	
	@Autowired // IoC 컨테이너가 관리하고 있는 객체중에서 해당하는 객체를 자동으로 주입하는 설정
	AppContextConfig2 config;
	
	@Bean 
	public MyServiceConsumer serviceConsumer() {
		MyServiceConsumer serviceConsumer = new MyServiceConsumer();
		
		serviceConsumer.setMessageService( config.messageService() );
		serviceConsumer.setTimeService( config.timeService() );
		return serviceConsumer;
	}
	
}


