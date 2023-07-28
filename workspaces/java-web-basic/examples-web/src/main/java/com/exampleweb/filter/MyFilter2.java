package com.exampleweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Filter 만들기
// 1. Filter 인터페이스 구현
// 2. 메서드 재정의 (특히 doFilter)
// 3. 필터 등록 ( web.xml 또는 @Filter annotation )

@WebFilter(urlPatterns = { "*.jsp" })
public class MyFilter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		String url = req.getRequestURI(); // 현재 처리 중인 요청 경로
		
		System.out.println(url + " 요청이 처리되고 있습니다 (in filter2).");
		
		if (url.contains("08-02.")) { // 요청 경로에 "08-01." 문자열이 포함되어 있으면
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect("/examples-web/"); // 다음 필터 또는 서블릿 또는 JSP는 처리되지 않음
		} else {
			chain.doFilter(request, response); // 다음 필터 또는 서블릿 또는 JSP 호출
		}
	}
	

}








