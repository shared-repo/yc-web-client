package com.demoweb.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class DemoWebListener implements ServletContextListener, HttpSessionListener  {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) { // 웹 프로그램이 시작될 때 호출되는 메서드
		ServletContext application = sce.getServletContext();
		// 비회원이 읽은 글을 저장하는 리스트를 application에 등록 (url, boardNo)
		application.setAttribute("userreadboard", new ArrayList<String[]>()); 
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) { // 웹 프로그램이 종료될 때 호출되는 메서드
		
	}

}
