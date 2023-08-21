package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.controller.HomeController;
import com.demoweb.controller.RegisterController;

@WebServlet(urlPatterns = { "*.action" })
public class FrontControllerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println(req.getRequestURI());
		//1. 요청 분석
		String url = req.getRequestURI();
		
		//2. 처리기 선택
		//3. 처리기 호출
		String result = null;
		if (url.contains("/home.action")) {
			HomeController controller = new HomeController();
			result = controller.handleRequest();
		} else if (url.contains("/account/login.action")) {
			
		} else if (url.contains("/account/register.action")) {
			RegisterController controller = new RegisterController();
			result = controller.handleRequest();
		} else if (url.contains("/account/logout.action")) {
			
		}		
		//4. 뷰 선택 ( 처리기 호출 결과에 따라 )
		//5. 뷰 호출 ( jsp로 forward or servlet으로 redirect )
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/" + result);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}

}
