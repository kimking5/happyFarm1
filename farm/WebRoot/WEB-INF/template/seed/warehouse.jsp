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
	</head>
	
	<body>
		<div style="width:33%;height:700px;">
			<div id="w" class="easyui-window" collapsible=false minimizable=false title="种子仓库" data-options="iconCls:'icon-seed-ck'"
				 maximizable=false sc8rolling="no" style="width:63%;height:390px;padding:10px;">
				<table id="warehouse"></table>
			</div>
		</div>
		
		<script>
			$(document).ready(function()
			{
				var cardview = $.extend({}, $.fn.datagrid.defaults.view, 
				{
					renderRow: function(target, fields, frozen, rowIndex, rowData)
					{
						var cc = [];
						if (!frozen)
						{
							var seedGrowStep;
							$.ajax(
	    				    {
	    				    	async: false,
	    			    	  	url:"<%=basePath%>cropsGrow/cropStep",
	    			    	  	data: {cId: rowData.cId, status: 3},
	    			    	  	success: function(data)
	    			    	  	{
	    			    	  		seedGrowStep = data.growStep;
	    			            },
	    			      	});
							var tip = getTip(rowData);
							var caption = "'" + rowData.caption + "'";
							cc.push('<div style="position:relative;float:left;">');
							cc.push('<div><div style="width:160px;font-size:12px;margin:0 0 0 10px;">'+rowData.tip+'</div>');
							cc.push('<div style="width:170px;height:180px;margin-left:6%;"><img src="<%=basePath%>/images/crops/' + rowData.cId + '/' + seedGrowStep + '.png" style="width:120px;height:140px;"/></div></div>');
							cc.push('<div style="width:190px;height:210px;z-index:3;position:absolute;top:0px;"><img class="easyui-tooltip" title="' + tip + '" src="<%=basePath%>/images/photoFrame.png" style="width:180px;height:210px;"/></div>');
							cc.push("<a class=\"op-linkbutton c1\" style=\"position:relative;left:55px;top:-35px;\" onclick='buy("+ JSON.stringify(rowData) +")'>我要购买</a></div>");
						}
						return cc.join('');
					}
				});
					
				card = $('#warehouse').edatagrid({
					view: cardview,
					width: 760,
					height: 330,
					method: 'post',
					url: '<%=basePath%>/seed/data',
					border: false,
					rownumbers: true,
					remoteSort: true,
					nowrap: false,
					singleSelect: true,
					fitColumns: true,
					pagination: true,
					striped: true,
					autoSave: true,
					idField: "id",
					pageNumber: 1,
					pageSize: 4,
					pageList: [4, 5, 10, 15],
					columns: [[
						{
							field: 'caption', title: '种子名称', width: 100, sortable: true, halign: 'center',
						},
						{
							field: 'cropLevel', title: '种子等级', width: 100, sortable: true, halign: 'center',
						},
						{
							field: 'type', title: '种子类型', width: 100, sortable: true, halign: 'center',
						},
						{
							field: 'landRequirement', title: '土地需求', width: 100, sortable: true, halign: 'center',
						}
					]],
				});
			});
			
			function getTip(rowData)
			{
				var list;
				getRemoteData('<%=basePath%>/codeSeedType/data', function(data)
				{
					list = data;
				});
				var type = fromCode2Caption(rowData.type, list);
				getRemoteData('<%=basePath%>/codeLandRequire/data', function(data)
				{
					list = data;
				});
				var land = fromCode2Caption(rowData.landRequirement, list);
				var tip = '名称：' + rowData.caption + '\r\n级别：' + rowData.cropLevel
					+ '\r\n价格：' + rowData.price + '金币\r\n类别：' + type
					+ '\r\n土地：' + land + '\r\n可收获季：' + rowData.harvestNum + '季'
					+ '\r\n成熟时间：' + rowData.matureTime + '秒\r\n单季收获：' + rowData.output + '个果实'
					+ '\r\n经验收获：' + rowData.exp + '\r\n单个果实可获金币：' + rowData.price4UnitSale + '个'
					+ '\r\n积分收获：' + rowData.score;
				return tip;
			}
			
			function buy(rowData)
			{
				$.messager.confirm('种子购买', '你确定要买<span style="color:yellow">' + rowData.caption + '</span>的种子么？', 
					function(data)
					{
						if (data)
						{
							var menuframe = $(window.parent.frames["menu"].document);
							if(menuframe.find(".userName").text() != "未知用户")
							{
								request(rowData, "post", "<%=basePath%>seedBag/示爱ve", function(data)
								{
									if (data.code == 0)
									{
										
						    		  	$.ajax(
				    				    {
				    			    	  	url:"<%=basePath%>user/user",
				    			    	  	data: {name:menuframe.find(".userName").text()},
				    			    	  	success: function(data)
				    			    	  	{
				    			    	  		var menuframe = $(window.parent.frames["menu"].document);
				    			    		  	menuframe.find('#exp').text(data.exp);
				    			    		  	menuframe.find('#goldCoin').text(data.goldCoin);
				    			    		  	menuframe.find('#score').text(data.score);
				    			            },
				    			      });
						    		  window.parent.frames["bot"].location.reload();
									}
									$.messager.show({
										title: "消息",
										msg: data.msg
									});
								});
							}
							else
							{
								$.messager.show({
									title: "消息",
									msg: "请先选择用户！"
								});
							}
						}
					}
				);
			}
		</script>
	</body>
</html>