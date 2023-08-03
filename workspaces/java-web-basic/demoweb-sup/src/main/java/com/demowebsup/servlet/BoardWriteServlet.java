package com.demowebsup.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demowebsup.dto.BoardDto;

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
		// 1-1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		// 1-2. DTO 객체에 저장
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo( (int)(Math.random() * 10000) + 1 ); // 임시로 난수 사용
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setWriteDate(new Date()); // 현재 시간으로 작성일자 적용
		
		// 2. 요청 처리 ( 다른 클래스 사용 )
		System.out.printf("[%s][%s]\n", title, content);
		// 임시로 모든 사용자가 공유하는 application 객체에 boardDto 객체 저장
		ServletContext application = req.getServletContext(); // ServletContext : jsp의 application객체와 같은 객체
		ArrayList<BoardDto> boards = (ArrayList<BoardDto>)application.getAttribute("boards");
		if (boards == null) {
			boards = new ArrayList<BoardDto>();
		}
		boards.add(boardDto);
		application.setAttribute("boards", boards);
		
		// 3. JSP에서 읽을 수 있도록 데이터를 request에 저장
		// 4. JSP로 forward 또는 다른 Servlet으로 redirect
		resp.sendRedirect("/demowebsup/board/list.action");
	}

}










