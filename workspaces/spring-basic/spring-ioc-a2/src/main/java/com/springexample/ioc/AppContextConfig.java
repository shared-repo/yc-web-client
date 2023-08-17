package com.springexample.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // app-context.xml과 같이 bean 설정을 수행하는 클래스로 지정
public class AppContextConfig {
	
	@Bean // xml 설정의 <bean id="serviceConsumer" class="...MyServiceConsumer"와 같은 효과
	public MyServiceConsumer serviceConsumer() {
		return new MyServiceConsumer();
	}

}
