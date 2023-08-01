package com.demowebsup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/account/logout.action" })
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 요청 데이터 읽기
		// 2. 요청 처리 ( 로그아웃 처리 )
		HttpSession session = req.getSession(); // request 객체에서 세션 가져오기
		session.removeAttribute("loginuser"); 	// 세션의 loginuser 정보만 제거
		// session.invalidate();				// 세션을 제거 (모든 세션데이터 제거)
		// 3. JSP에게 전달할 데이터를 request객체에 저장
		// 4. home으로 이동
		resp.sendRedirect("/demowebsup/home.action");
		
	}
	
}






