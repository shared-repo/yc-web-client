package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 만들기
// 1. HttpServlet 상속
// 2. @WebServlet 매핑
// 3. doGet or doPost 구현

@WebServlet(urlPatterns = { "/account/register.action" }) // 서버 코드에서는 절대 경로에 웹애플리케이션 이름 사용 X
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 데이터 읽기 : req.getParameter("이름")
		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		String confirm = req.getParameter("confirm");
		String email = req.getParameter("email");
		
		System.out.printf("[%s][%s][%s][%s]\n", memberId, passwd, confirm, email);
		
	}
}











