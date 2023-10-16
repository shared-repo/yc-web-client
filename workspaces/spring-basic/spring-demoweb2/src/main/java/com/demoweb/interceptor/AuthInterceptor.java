package com.demoweb.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.demoweb.dto.MemberDto;

// interceptor 클래스는 HandlerInterceptor 인터페이스를 구현해야 합니다.
public class AuthInterceptor implements HandlerInterceptor {
	
	// Controller 실행 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// System.out.println("preHandle");
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("loginuser");
		// 컨트롤러 호출 여부 결정 가능 ( 반환 값이 true : 호출, 반환 값이 false이면 호출 생략 )
		if (member == null) { // 로그인 하지 않은 경우
			
			String currentUrl = request.getRequestURI(); // 현재 요청된 경로를 문자열로 반환
			if (currentUrl.contains("ajax-write-comment")) {
				response.setContentType("text/plain;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("unauthorized");
			} else {
				currentUrl = currentUrl.replace("/spring-demoweb", "");
				response.sendRedirect("/spring-demoweb/account/login?returnUrl=" + currentUrl);
			}
			return false;
		} else {
			return true;	
		}
		
	}
	
	// Controller 실행 후에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// System.out.println("postHandle");
	}
	// 요청 처리가 모두 끝난 후에 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// System.out.println("afterCompletion");
	}

}
