package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hello-servlet.action" }) // hello-servlet.action 요청에 대해 호출될 서블릿으로 등록
public class HelloServlet extends HttpServlet { // HttpServlet을 상속하면 Servlet 클래스로 사용할 수 있습니다.

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>hello, servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello, Servlet</h1>");
		out.println("<h2>" + new Date() + "</h>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}






