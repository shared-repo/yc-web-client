package com.demowebsup.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demowebsup.dto.BoardDto;

@WebServlet(urlPatterns = { "/board/detail.action" })
public class BoardDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		String sBoardNo = req.getParameter("boardno"); // getParameter : 항상 문자열 반환
		int boardNo = Integer.parseInt(sBoardNo); // 문자열 -> 정수 변경		
		// 2. 요청 처리 ( 다른 클래스 사용 )
		ServletContext application = req.getServletContext();
		ArrayList<BoardDto> boards = (ArrayList<BoardDto>)application.getAttribute("boards");
		BoardDto selectedBoard = null;
		for (BoardDto board : boards) {
			if (board.getBoardNo() == boardNo) {
				selectedBoard = board;
				break;
			}
		}		
		// 3. JSP에서 읽을 수 있도록 데이터를 request에 저장
		req.setAttribute("board", selectedBoard);
		// 4. JSP로 forward 또는 다른 Servlet으로 redirect
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp");
		dispatcher.forward(req, resp);
	}
	
}
