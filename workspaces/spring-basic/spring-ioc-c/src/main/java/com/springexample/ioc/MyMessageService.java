package com.springexample.ioc;

import org.springframework.stereotype.Component;

@Component("messageService") // xml 설정 파일의 <bean ... /> 또는 @Configuration 설정의 @Bean과 같은 의미
public class MyMessageService implements MessageService {
	
	int data;
	public MyMessageService() {
		data = (int)(Math.random() * 900) + 100;
	}
	
	public String getMessage() {
		return String.format("Hello, Spring IoC Container (%d) !!!", data);
	}
	
	public void init() {
		System.out.println("MyMessageService.init()");
	}
	
	public void destroy() {
		System.out.println("MyMessageServce.destroy()");
	}

}
