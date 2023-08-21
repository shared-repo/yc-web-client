package com.springexample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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
	
	@Pointcut("execution( * com.springexample.aop.Test*.*(..) )")
	public void pointcutAll() {}
	
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
	
	@Around("pointcutAll()")
	public Object logAround(ProceedingJoinPoint joinPoint) { // around advice의 전달인자는 필수
		
		// before area
		long start = System.nanoTime(); // 현재 시간
		// long start = System.currentTimeMillis(); // 현재 시간
		
		Object returnValue = null;
		try {
			returnValue = joinPoint.proceed(); // 실제 메서드 호출
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		// after area
		long stop = System.nanoTime(); // 현재 시간
		// long stop = System.currentTimeMillis(); // 현재 시간
		
		long lap = stop - start;
		System.out.printf("%s.%s 실행 소요 시간 : %d\n",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), 
				lap);
		
		return returnValue; // 실제 메서드 호출의 반환 값을 대신 반환
		
	}
	
	

}











