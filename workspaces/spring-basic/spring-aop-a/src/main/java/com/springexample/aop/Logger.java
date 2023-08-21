package com.springexample.aop;

import org.aspectj.lang.JoinPoint;

public class Logger {
	
	// public void logBefore() {
	public void logBefore(JoinPoint joinPoint) { // JoinPoint : 현재 Advice가 적용되는 (현재 실행중인) 대상 메서드 정보 
		
		System.out.printf("==========>Logger.logBefore : %s.%s<==========",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
		
	}
	
	// public void logBefore() {
	public void logAfter(JoinPoint joinPoint) { // JoinPoint : 현재 Advice가 적용되는 대상 메서드
		
		System.out.printf("==========>Logger.logAfter : %s.%s<==========",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
		
	}

}
