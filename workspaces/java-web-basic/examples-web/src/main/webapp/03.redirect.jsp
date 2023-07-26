<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
pageContext.setAttribute("page-data", "This is Page Scope Data (from redirect)");
request.setAttribute("req-data", "This is Request Scope Data (from redirect)");


response.sendRedirect("03.result.jsp");

%>