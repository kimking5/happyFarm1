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
	    </style>
	</head>
	
	<body>
		<div style="width:100%;height:800px;">
			<div class="easyui-window" data-options="iconCls:'icon-man',modal:true" closable=false
				style="width:380px;height:200px;padding:5px;" title="用户选择" collapsible=false 
				minimizable=false maximizable=false scrolling="no" >
				
				<table id="userGrid" >
					<tr>
						<td>当前用户：</td>
					</tr>
					<tr>
						<td>
							<input id="cbox" style="width:350px;" class="easyui-combobox" 
								data-options="url: '<%=basePath%>/selectUser/data',
								method: 'get',
								valueField: 'id',
								textField: 'name',
								panelWidth: 350,
								panelHeight: 'auto',
								formatter: formatItem">
						</td>
					</tr>
					<tr>
						<td>
							<hr>
						</td>
					</tr>
					<tr>
						<td>
							<div style="float:left;margin-right:25px;">
								请在下拉框中选择用户名称，并点击“确定”<br/>按钮设置当前用户信息
							</div>
							<a id="select_btn" href="#" class="easyui-linkbutton c1" onclick="">确认</a>
						</td>
					</tr>
				</table>
			</div>
			
			<div id="msgBox" class="easyui-dialog" buttons="#confirm" closed="true"
					style="width:300px; height:150px; padding:10px 20px" >
				<div id="confirm">
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#msgBox').dialog('close')">关闭窗口</a>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			var dataAll = [];
			var count = 0;
			function formatItem(row)
			{
				dataAll[count] = row;
				count++;
				var imageFile = '<%=basePath%>/images/headImages/' + row.headImg;
				var s = '<img class="item-img" src="'+imageFile+'"/> &nbsp;' +
						'<span style="color:white";>' + row.name + '</span>&nbsp;|&nbsp;' + 
						'<span style="color:white">经验：</span>' + '<span style="color:white">' + row.exp + '</span>&nbsp;|&nbsp;' + 
						'<span style="color:white">金币：</span>' + '<span style="color:white">' + row.goldCoin + '</span>&nbsp;|&nbsp;' + 
						'<span style="color:white">积分：</span>' + '<span style="color:white">' + row.score + '</span>';
				return s;
			}
			
			$('#select_btn').click(function ()
			{
			    var userId = $('#cbox').combo('getValue');
			  	if(userId == null || userId == "")
			  	{
			  		$.messager.show({
						title: "消息",
						msg: "请选择用户！"
					});
			  	}
			  	else
		  		{
			  		$.ajax(
				    {
			    	  	url:"<%=basePath%>selectUser/setCurrentUser",
			    	  	data: {id:userId},
			    	  	success: function(data)
			    	  	{
			    	  		var menuframe = $(window.parent.frames["menu"].document);
			    		  	menuframe.find(".userName").text(data.name);
			    		  	menuframe.find('.userImg').attr('src','images/headImages/'+data.headImg);
			    		  	menuframe.find('#exp').text(data.exp);
			    		  	menuframe.find('#goldCoin').text(data.goldCoin);
			    		  	menuframe.find('#score').text(data.score);
			    		  	$.messager.show({
								title: "消息",
								msg: "当前用户已经设定为"+ data.name + "[" + data.nickName +"]"
							});
			            },
			            error: function()
			            {
			            	$.messager.show({
								title: "消息",
								msg: "登录失败"
							});
			            }
			      	});
		  		}
			});
		</script>
	</body>
</html>