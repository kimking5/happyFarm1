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
	    <style type="text/css">
	    	.seedBag{
	    		display:block;
	    		width:600px;
	    		height:160px;
	    		margin:0 auto;
	    		overflow:hidden;
	    	}
	    	.seedBag tr{
	    		width:100%;
	    		height:100%;
	    	}
	    	.seedBag tr td{
	    		display:block;
	    		float:left;
	    		width:115px;
	    		height:160px;
	    		text-align:center;
	    	}
	    	
	    	.seedBag tr td span{
	    		display:block;
	    		width:30px;
	    		height:30px;
	    		border-radius:15px;
	    		background:red;
	    		color:#FFF;
	    		font-size:1em;
	    		text-align:center;
	    		line-height:30px;
	    		position:relative;
	    		top:10px;
	    		left:40px
	    	}
	    	
	    	.seedBag tr td img{
	    		width:70%;
	    		height:70%;
	    		position:relative;
	    		top:20px;
	    	}
	    	
	    </style>
	</head>
	
	<body>
		<a id="navigate-left" >
			<img src="<%=basePath%>images/navigate-left.png" style="position:absolute;left:20%;top:50px" height="100px" >
		</a>
		<table border="0" cellspacing="0" cellpadding="0" class="seedBag" id="seedBagGrid" >
			<tr></tr>
		</table>
		<a id="navigate-right">
			<img src="<%=basePath%>images/navigate-left.png" style="transform:rotate(180deg);position:absolute;left:70%;top:50px" height="100px" >
		</a>
		<script>
			var count = 0;
			$("#navigate-right").click(function()
			{
				count += 1;
				if(count>=Math.ceil($("table tr").children().length/5))
				{
					count = Math.ceil($("table tr").children().length/5)-1;
				}
				$("#seedBagGrid").scrollTop($("#seedBagGrid").height()*count);
			});
			
			$("#navigate-left").click(function()
			{
				$("#seedBagGrid").scrollTop($("#seedBagGrid").height()*count-$("#seedBagGrid").height());
				count -= 1;
				if(count <= 0)
				{
					count = 0;
				}
			});

			var userName = $(window.parent.frames["menu"].document).find(".userName").text();
			
			$.ajax({
	             type: "POST",
	             url: '<%=basePath%>seedBag/data',
	             data:{userName:userName},
	             dataType: "json",
	             success: function(data)
	             {
	            	 $.each(data,function(i, data)
	            	 {
	            		 var seedGrowStep;
						$.ajax(
    				    {
    				    	async: false,
    			    	  	url:"<%=basePath%>cropsGrow/cropStep",
    			    	  	data: {cId: data.cId, status: 3},
    			    	  	success: function(data)
    			    	  	{
    			    	  		seedGrowStep = data.growStep;
    			            },
    			      	});
	            		 var result = "<td><span>"+data.seedNum+'</span><img src="<%=basePath%>images/crops/'+data.cId+'/' + seedGrowStep + '.png" height="70px" ></td>'
	   	                  $("table tr").append(result);
	            	 })
	             }
	         });
		</script>
	</body>
</html>