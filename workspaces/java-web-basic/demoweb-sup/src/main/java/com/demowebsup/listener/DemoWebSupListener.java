package com.demowebsup.listener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		ServletContext application = sce.getServletContext();
		
		// 게시글 데이터를 파일에서 읽기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<BoardDto> boards = null;
		int nextBoardNo = 1;
		try {
			String path = application.getRealPath("/WEB-INF/boards.dat"); // 웹경로 -> 컴퓨터경로
			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);
			boards = (ArrayList<BoardDto>)ois.readObject(); // Object -> 사용할 타입으로 형변환 필요
			int size = boards.size(); // 리스트에 포함된 객체의 갯수
			if (size > 0) { // 리스트에 포함된 객체가 1개 이상인 경우에만 처리
				BoardDto lastBoard = boards.get(size-1); // 리스트의 마지막 요소 반환
				nextBoardNo = lastBoard.getBoardNo() + 1;
			}
		} catch (Exception ex) {
			boards = new ArrayList<BoardDto>(); // 파일 데이터 읽기 실패하면 게시글을 저장할 새 배열 만들기
			ex.printStackTrace();
		} finally {	
			try { ois.close(); } catch (Exception ex) {}
			try { fis.close(); } catch (Exception ex) {}
		}		
		// 게시판 데이터 저장소 초기화
		application.setAttribute("boards", boards); // 배열을 application 객체에 저장		
		// 새 게시글에 부여할 글번호 초기화
		application.setAttribute("nextBoardNo", nextBoardNo);
	}
	// 웹 애플리케이션 정상 종료할 때 호출
	public void contextDestroyed(ServletContextEvent sce) {
		
		// 파일에 저장할 게시글 데이터를 application(ServletContext) 객체에서 읽어오기
		ServletContext application = sce.getServletContext();
		ArrayList<BoardDto> boards = (ArrayList<BoardDto>)application.getAttribute("boards");
		
		// 게시글 데이터를 파일에 저장
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			String path = application.getRealPath("/WEB-INF/boards.dat"); // 웹경로 -> 컴퓨터경로
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(boards);
		} catch (Exception ex) {
			ex.printStackTrace(); // 현재 예외 정보를 콘솔에 출력하는 명령
		} finally {
			// oos.close(); // 예외처리 필수 구문
			try { oos.close(); } catch (Exception ex) {}
			try { fos.close(); } catch (Exception ex) {}
		}
	}

}







