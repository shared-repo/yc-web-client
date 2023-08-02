package com.demowebsup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/board/write.action" })
public class BoardWriteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		// 2. 요청 처리 ( 다른 클래스 사용 )
		// 3. JSP에서 읽을 수 있도록 데이터를 request에 저장
		// 4. JSP로 forward 또는 다른 Servlet으로 redirect
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		// 2. 요청 처리 ( 다른 클래스 사용 )
		System.out.printf("[%s][%s]\n", title, content);
		// 3. JSP에서 읽을 수 있도록 데이터를 request에 저장
		// 4. JSP로 forward 또는 다른 Servlet으로 redirect
		resp.sendRedirect("/demowebsup/board/list.action");
	}

}










