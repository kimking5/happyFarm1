<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link rel="stylesheet" type="text/css" href="<%=basePath%>ext/farm/farm.css">
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/jquery.easyui.min.js"></script>
	     <script type="text/javascript" src="<%=basePath%>ext/easyui/plugins/jquery.edatagrid.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/plugins/jquery.draggable.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/locale/easyui-lang-zh_CN.js"></script>
	    
		<title>菜单</title>
		<style>
	        body
	        {
	            margin: 0px;           
	        }
	        .bar
	        {
	        	background-image:url(images/topbar.png);        	
	            background-size:25% 60px;
	            background-repeat:repeat-x;            
	        }
	        .shadow
	        {
	        	-moz-box-shadow:2px 2px 5px #333333;
	        	-webkit-box-shadow:2px 2px 5px #333333;
	        	box-shadow:2px 2px 5px #333333;
	        }
	        .menu
	        {
	           margin: 3px 5px 5px 5px;
	        }
	        .userName
	        {
	        	font-size: 22px;
	        	font-weight:bold;
	        	color: black;
	        }
	        .userInfo
	        {
	        	background-color: blue;
	        	border-radius: 6px;
	        }
	    </style>
	</head>
	
	<body class="bar">
		<div align="left" style="width:40%;float:left;">
			<img class="userImg menu shadow" src="<%=basePath%>/images/QQ.png" style="float:left;" width="50px">
			<div width="150px" style="float:left; margin-top:5px;">
				<a class="userName">未知用户</a>
				<div class="userInfo">
					<a style="color:#49baef">经验：</a><a id="exp" style="color:#49baef">0</a>
					<a style="color:#b5e98a">金币：</a><a id="goldCoin" style="color:#b5e98a">0</a>
					<a style="color:#eb8895">积分：</a><a id="score" style="color:#eb8895">0</a>
				</div>
			</div>
		</div>
		<div align="right" style="width:100%;">
			<a href="land/grid" target="workspace" onclick="returnBack()">
				<img class="menu shadow" src="images/land.png" width="50px">
			</a>
			<a href="selectUser/grid" target="workspace" onclick="returnBack()">
				<img class="menu shadow" src="images/farmer.png" width="50px">
			</a>
			<a href="seed/warehouse" target="workspace" onclick="seedBag()">
				<img class="menu shadow" src="images/shop2.png" width="50px">
			</a>
			<a href="user/grid" target="workspace" onclick="returnBack()">
				<img class="menu shadow" src="images/user.png" width="50px">
			</a>
			<a href="seed/grid" target="workspace" onclick="returnBack()">
				<img class="menu shadow" src="images/seedManager.png" width="50px">
			</a>
		</div>
		<script type="text/javascript">
			function seedBag()
			{
				var ck = window.parent;
				ck.document.getElementsByTagName("frameset")[0].rows = "60,*,160";
				ck.document.getElementById("bottom").src = "seedBag/grid";
			}
			function returnBack()
			{
				var ck = window.parent;
				ck.document.getElementsByTagName("frameset")[0].rows = "60,*,50";
				ck.document.getElementById("bottom").src = "tools.jsp";
			}
		</script>
	</body>
</html>