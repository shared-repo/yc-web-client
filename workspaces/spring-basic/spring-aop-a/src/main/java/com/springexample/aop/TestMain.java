package com.springexample.aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("app-context.xml");
		
		TestA a = context.getBean("testA", TestA.class);
		TestB b = context.getBean("testB", TestB.class);
		
		a.doSomething1();
		a.doSomething2();
		b.doSomething1();
		b.doSomething2();
		a.doAnother1();
		a.doAnother2();
		b.doAnother1();
		b.doAnother2();
		
		context.close();

	}

}
