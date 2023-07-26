package com.exampleweb.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet 만들기
// 1. HttpServlet 상속
// 2. @WebServlet 매핑 설정
// 3. doGet, doPost 재정의

@WebServlet(urlPatterns = { "/model2" })
public class Model2Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 요청 데이터 읽기 (여기서는 생략 - 데이터 없음)
		
		//2. 요청 처리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String dateString = sdf.format(new Date());
		
		// JSP에서 읽을 수 있도록 Request 객체에 데이터 저장
		req.setAttribute("date", dateString);
		
		//3. 응답 컨텐츠 생상 ( JSP에서 처리 - forward로 이동)
		RequestDispatcher dispatcher = req.getRequestDispatcher("04.model2.jsp");
		dispatcher.forward(req, resp);
	}

}







