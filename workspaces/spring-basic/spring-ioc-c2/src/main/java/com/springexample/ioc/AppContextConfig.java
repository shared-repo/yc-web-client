package com.springexample.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // app-context.xml과 같이 bean 설정을 수행하는 클래스로 지정
@ComponentScan(basePackages = { "com.springexample.ioc" })
public class AppContextConfig {
	
	
}


