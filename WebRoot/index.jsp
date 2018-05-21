<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <base href="<%=basePath%>">
	    <title>我的农场</title>
	    <style>
	        body
	        {
	            margin: 0px; 
	        }
	    </style>
	</head>
	
	<frameset rows="60,*,50" border="0">
		<frame src="menu.jsp" scrolling="no">
		<frame name="workspace" src="welcome.jsp" scrolling="no">
		<frame src="tools.jsp" scrolling="no"> 		
	</frameset>
</html>