package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/account/login.action" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 요청 데이터 읽기
		// 2. 요청 처리
		// 3. JSP에게 전달할 데이터를 request객체에 저장
		// 4. JSP로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account/login.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		
		// 2. 요청 처리
		System.out.printf("[%s][%s]\n", memberId, passwd);
		
		// 3. JSP에게 전달할 데이터를 request객체에 저장
		
		// 4. 일련의 작업이 끝났으면 redirect로 이동
		resp.sendRedirect("/demoweb/home.action");
		
	}
}






