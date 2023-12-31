package com.exampleweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ExampleWebListener implements ServletContextListener, HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  {
    	System.out.println("Session Start !!!!!");
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	System.out.println("Session Finish !!!!!");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Application Finish !!!!");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Application Start !!!!");
    }
	
}
