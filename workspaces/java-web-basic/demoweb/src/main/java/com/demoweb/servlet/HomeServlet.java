package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home.action" })
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 요청 데이터 읽기
		// 2. 요청 처리
		// 3. JSP에게 전달할 데이터를 request객체에 저장
		// 4. JSP로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}






