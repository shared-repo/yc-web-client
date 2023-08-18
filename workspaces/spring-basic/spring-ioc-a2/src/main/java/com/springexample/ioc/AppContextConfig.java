package com.springexample.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // app-context.xml과 같이 bean 설정을 수행하는 클래스로 지정
public class AppContextConfig {
	
	@Bean 	// xml 설정의 <bean id="serviceConsumer" class="...MyServiceConsumer"와 같은 효과
			// 메서드 이름이 bean의 id가 됩니다.
	@Scope("singleton") // or prototype
	public MyServiceConsumer serviceConsumer() {
		// return new MyServiceConsumer();
		MyServiceConsumer serviceConsumer = new MyServiceConsumer();
		serviceConsumer.setMessageService( messageService() ); // 빈 생성 메서드 호출 : getBean과 같은 의미
		serviceConsumer.setTimeService( timeService() );
		return serviceConsumer;
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Scope("singletone")
	public MyMessageService messageService() {
		return new MyMessageService();
	}
	
	@Bean
	public MyTimeService timeService() {
		// return new MyTimeService();
		return new MyTimeService("yyyy-MM-dd a hh:mm:ss"); // 생성자 주입 사용
	}

}


