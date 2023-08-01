package com.demowebsup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demowebsup.lib.Lotto;

@WebServlet(urlPatterns = { "/exchange-rate.action" })
public class ExchangeRateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 데이터 읽기
		// 2. 요청 처리
		// 3. JSP에서 사용할 수 있도록 request에 데이터 저장
		// 4. JSP로 forward 이동 or 다른 서블릿으로 redirect 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/exchange-rate.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		String exchangeType = req.getParameter("exchangeType");
		String sAmount = req.getParameter("amount"); // req.getParameter : 항상 문자열로 반환
		double amount = Double.parseDouble(sAmount); // parseDouble : String -> Double 변환
		// 2. 요청 처리
		double exchangeRate = 1281.56;
		double result = 0;
		switch (exchangeType) {
		case "w2d": 
			result = amount / exchangeRate;
			break;
		case "d2w": 
			result = amount * exchangeRate;
			break;
		}
		// 3. JSP에서 사용할 수 있도록 request에 데이터 저장
		req.setAttribute("result", result);
		// 4. JSP로 forward 이동 or 다른 서블릿으로 redirect 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/exchange-rate.jsp");
		dispatcher.forward(req, resp);
	}

}
