<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/easyui/themes/green/easyui.css?t564">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/easyui/themes/icon.css">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/easyui/themes/color.css">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/farm/farm.css">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/farm/imgPosition.css?t=0901">
	    
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/plugins/jquery.edatagrid.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/plugins/jquery.draggable.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/locale/easyui-lang-zh_CN.js"></script>
	    
	    <script type="text/javascript" src="<%=basePath%>ext/farm/helper.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/farm/imgPosition.js"></script>
		<title>欢迎首页</title>
		<style>
	        body
	        {
	            margin: 0px;
	            background-image:url(images/welcome.png);
	            background-size:100% 100%;
	            background-repeat:no-repeat;
	            background-color: transparent;
				border:none;
				width:100%;
				height:100%;
	        }
	    </style>
	</head>
	
	<body>
	</body>
</html>