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
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/easyui/themes/green/easyui.css?t=34355">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/easyui/themes/icon.css">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/easyui/themes/color.css">
	    <link rel="stylesheet" type="text/css" href="<%=basePath%>ext/farm/farm.css">
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/plugins/jquery.edatagrid.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/easyui/locale/easyui-lang-zh_CN.js"></script>
	    <script type="text/javascript" src="<%=basePath%>ext/farm/helper.js?346t"></script>    
	</head>
	
	<body>
		<div id="formUserContainer" class="easyui-panel" buttons="#formUserButtons"
			style="width:580px; height:60px; padding:10px 20px">
			<form id="formHeadImg" method="POST" enctype="multipart/form-data">
				<span>头像文件： </span>
				<input id="file1" name="filePathName" class="easyui-filebox" style="width:400px;" 
						data-options="prompt:'请先选择文件需要上传的文件...',buttonText:'选择文件'">
			</form>
		</div>
		
		<div id="formUserButtons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" 
				onclick="upload()">开始上传</a>
		</div>
		
		<script type="text/javascript">
			function upload()
			{
				var formData = new FormData($("#formHeadImg")[0]);
				$("#formHeadImg").form('submit', 
				{
	                type:"post", 
	                url: "<%=basePath%>/file/saveHeadImg",
	                data: formData,
	                success:function(data)
	                {
	                	var result = eval('(' + data + ')');
						alert(result.msg);
	                }
	            });
			}
		</script>
	</body>
</html>