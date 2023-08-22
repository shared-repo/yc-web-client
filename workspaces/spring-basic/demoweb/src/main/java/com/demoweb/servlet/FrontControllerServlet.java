package com.demoweb.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.controller.HomeController;
import com.demoweb.controller.LoginController;
import com.demoweb.controller.RegisterController;
import com.demoweb.dto.HandleResultDto;
import com.demoweb.dto.MemberDto;

@WebServlet(urlPatterns = { "*.action" })
public class FrontControllerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println(req.getRequestURI());
		//1. 요청 분석
		String url = req.getRequestURI();
		
		//2. 처리기 선택
		//3. 처리기 호출
		String method = req.getMethod().toLowerCase(); // "get" or "post"
		HandleResultDto result = null;
		if (url.contains("/home.action")) {
			
			HomeController controller = new HomeController();
			result = controller.handleRequest(method, null);
			
		} else if (url.contains("/account/login.action")) {
			
			// 1. 요청 데이터 읽기
			MemberDto member = null;
			if (method.equals("post")) {
				String memberId = req.getParameter("memberId");
				String passwd = req.getParameter("passwd");
				member = new MemberDto();
				member.setMemberId(memberId);
				member.setPasswd(passwd);
			}
			
			LoginController controller = new LoginController();
			result = controller.handleRequest(method, member);
			
			if (result.getData() != null) { // 로그인 성공
				// 로그인 처리 - 세션에 로그인 정보 저장
				HttpSession session = req.getSession(); // 요청 객체로부터 세션 객체 가져오기
				session.setAttribute("loginuser", member.getMemberId()); // 세션에 데이터 저장
			}
			
		} else if (url.contains("/account/register.action")) {
			MemberDto member = null;
			if (method.equals("post")) {
				// 1-1. 요청 데이터 읽기 : req.getParameter("이름")
				String memberId = req.getParameter("memberId");
				String passwd = req.getParameter("passwd");
				String confirm = req.getParameter("confirm");
				String email = req.getParameter("email");
				
				// 1-2. MemberDto 객체에 요청 데이터 저장
				member = new MemberDto();
				member.setMemberId(memberId);
				member.setPasswd(passwd);
				member.setEmail(email);
				member.setRegDate(new Date());
			}
			
			RegisterController controller = new RegisterController();
			result = controller.handleRequest(method, member);
		} else if (url.contains("/account/logout.action")) {
			HttpSession session = req.getSession(); // request 객체에서 세션 가져오기
			session.removeAttribute("loginuser");
			result = new HandleResultDto(true, "/demoweb/home.action", null);
		}
		
		//4. 뷰 선택 ( 처리기 호출 결과에 따라 )
		//5. 뷰 호출 ( jsp로 forward or servlet으로 redirect )
		if (result.isRedirect()) {
			resp.sendRedirect(result.getViewName());
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/" + result.getViewName());
			dispatcher.forward(req, resp);	
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}

}
