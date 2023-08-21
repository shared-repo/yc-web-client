package com.demoweb.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.demoweb.dto.MemberDto;

@WebListener
public class DemoWebListener implements ServletContextListener, HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {}
    public void sessionDestroyed(HttpSessionEvent se) {}

    // 웹프로그램 시작할 때 한 번 호출
    public void contextInitialized(ServletContextEvent sce)  {
    	// 회원가입정보를 저장할 ArrayList 객체를 만들고 application 객체에 저장
    	ServletContext application = sce.getServletContext();
    	ArrayList<MemberDto> members = new ArrayList<MemberDto>();
    	application.setAttribute("members", members);
    }
    // 웹프로그램 종료할 때 한 번 호출
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
    
	
}
