<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
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
	    <style>
	    	.item-img{
	    		width: 50px;
	    		height: 50px;
	    	}
	    	.landContainer{
	    		margin-top:200px;
	    		margin-left:50px;
	    		overflow:hidden;
	    	}
	    	.landContainer img{
	    		width:150px;
	    		height:auto;
	    		margin:0;
	    		position:absolute;
	    		overflow:hidden;
	    	}
	    </style>
	</head>
	
	<body>
	<script>
		
	</script>
	<div style="width:100%;height:800px;" class="landContainer">
		<div class="landContainer">
			
		</div>
		
	</div>			
	<script type="text/javascript">
	for(var i=1;i<5;i++)
	{
	for(var j=0;j<6;j++)
		{
			var img = '<img class="basicLand" src="images/land'+ 
			i + '.png" style="top:' + 
			(255-i*55+j*75) + 'px;left:' + 
			(115*i+150*j+35)+ 'px;" >';
			$(".landContainer").append(img);
		}
	}
	//$(".basicLand").
	</script>
	</body>
</html>