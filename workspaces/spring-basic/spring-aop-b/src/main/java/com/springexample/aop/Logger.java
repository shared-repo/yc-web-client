package com.springexample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logger {
	
	@Pointcut("bean(testA)")
	public void pointcutA() {}
	
	@Pointcut("within(com.springexample.aop.*B)")
	public void pointcutB() {}
	
	@Pointcut("execution( * *..*.*1(..) )")
	public void pointcut1() {}
	
	// @Before("bean(testA)") // 포인트컷 표현식을 직접 적용 가능
	@Before("pointcutA()")
	public void logBefore(JoinPoint joinPoint) { // JoinPoint : 현재 Advice가 적용되는 (현재 실행중인) 대상 메서드 정보 
		
		System.out.printf("==========>Logger.logBefore : %s.%s<==========\n",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
		
	}
	
	@After("pointcutB()")
	public void logAfter(JoinPoint joinPoint) { // JoinPoint : 현재 Advice가 적용되는 대상 메서드
		
		System.out.printf("==========>Logger.logAfter : %s.%s<==========\n",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
		
	}

}
