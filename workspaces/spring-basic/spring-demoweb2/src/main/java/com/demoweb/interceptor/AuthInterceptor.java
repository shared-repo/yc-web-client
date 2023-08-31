package com.demoweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// interceptor 클래스는 HandlerInterceptor 인터페이스를 구현해야 합니다.
public class AuthInterceptor implements HandlerInterceptor {
	
	// Controller 실행 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		// 컨트롤러 호출 여부 결정 가능 ( 반환 값이 true : 호출, 반환 값이 false이면 호출 생략 )
		return true;
	}
	
	// Controller 실행 후에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}
	// 요청 처리가 모두 끝난 후에 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
	}

}
