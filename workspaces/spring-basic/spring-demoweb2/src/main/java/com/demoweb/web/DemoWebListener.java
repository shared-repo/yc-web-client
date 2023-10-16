package com.demoweb.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		String path = application.getRealPath("/WEB-INF/nonmenberreaddata.dat");
		
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<String[]> userReadBoard = (List<String[]>)ois.readObject();
			// 비회원이 읽은 글을 저장하는 리스트를 application에 등록 (url, boardNo)
			application.setAttribute("userreadboard", userReadBoard); 
		} catch (Exception ex) {
			// 비회원이 읽은 글을 저장하는 리스트를 application에 등록 (url, boardNo)
			application.setAttribute("userreadboard", new ArrayList<String[]>()); 
		}
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) { // 웹 프로그램이 종료될 때 호출되는 메서드
		
		ServletContext application = sce.getServletContext();
		List<String[]> userReadBoard = (List<String[]>)application.getAttribute("userreadboard");
		String path = application.getRealPath("/WEB-INF/nonmenberreaddata.dat");
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userReadBoard);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
