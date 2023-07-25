package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/process-data")
public class ProcessDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 데이터 읽기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// 서버 콘솔에 출력
		System.out.printf("%s - %s\n", name, email);
		
		// 클라이언트에게 응답 전송 --> 클라이언트 브라우저에 출력
		response.setContentType("text/html;charset=utf-8"); // 브라우저에게 응답 컨텐츠의 종류를 알려주는 설정
		PrintWriter out = response.getWriter();
		out.println(String.format("<h2>%s</h2><h2>%s</h2>", name, email));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); // 요청 데이터를 읽을 때 적용할 문자 인코딩 지정 (한글 읽기 가능하도록 설정)
		// get 요청과 post 요청 처리가 같은 경우 doGet으로 호출 전달
		doGet(request, response);
	
	}

}
