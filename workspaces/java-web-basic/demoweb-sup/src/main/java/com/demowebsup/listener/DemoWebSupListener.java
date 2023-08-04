package com.demowebsup.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.demowebsup.dto.BoardDto;

@WebListener
public class DemoWebSupListener implements ServletContextListener, HttpSessionListener {

	public DemoWebSupListener() {
	}

	// 세션이 시작할 때 ( 브라우저에서 처음으로 세션 사용 요청이 발생할 때 )
	public void sessionCreated(HttpSessionEvent se) {
	}
	// 세션이 종료할 때 ( 마지막 세션 사용 요청 이후 일정 시간동안 추가 요청이 없거나 invalidate() 메서드가 호출될 때 )
	public void sessionDestroyed(HttpSessionEvent se) {
	}

	// 웹 애플리케이션 시작할 때 한 번만 호출
	public void contextInitialized(ServletContextEvent sce) {
		// 게시판 데이터 저장소 초기화
		ServletContext application = sce.getServletContext();
		ArrayList<BoardDto> boards = new ArrayList<BoardDto>(); // 게시글을 저장할 배열 만들기
		application.setAttribute("boards", boards); // 배열을 application 객체에 저장
		
		// 새 게시글에 부여할 글번호 초기화
		application.setAttribute("nextBoardNo", 1);
	}
	// 웹 애플리케이션 종료할 때 호출
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
