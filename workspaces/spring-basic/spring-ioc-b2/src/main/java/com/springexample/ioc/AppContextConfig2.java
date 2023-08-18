package com.springexample.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // app-context.xml과 같이 bean 설정을 수행하는 클래스로 지정
public class AppContextConfig2 {
	
	@Bean
	public MyMessageService messageService() {
		return new MyMessageService();
	}
	
	@Bean
	public MyTimeService timeService() {
		// return new MyTimeService();
		return new MyTimeService("yyyy-MM-dd a hh:mm:ss"); // 생성자 주입 사용
	}

}


