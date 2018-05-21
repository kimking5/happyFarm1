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
		<div id="controlBox">
			<span style="color:white">种子名称:</span>
			<input id="captionSearch" class="easyui-textbox" panelHeight="auto">
			<a href="#" class="easyui-linkbutton c1" iconCls="icon-search" onclick="doSearch()">查询</a>
			<a href="#" class="easyui-linkbutton c2" iconCls="icon-add" onclick="addForm()">添加</a>
			<a href="#" class="easyui-linkbutton c4" iconCls="icon-edit" onclick="editForm()">编辑</a>
			<a href="#" class="easyui-linkbutton c3" iconCls="icon-cancel" onclick="javascript:grid.edatagrid('cancelRow')">取消</a>
			<a href="#" class="easyui-linkbutton c5" iconCls="icon-remove" onclick="javascript:grid.edatagrid('destroyRow')">删除</a>
		</div>
		
		<table id="seedListGrid"></table>
		
		<div id="msgBox"></div>
		
		<div id="formSeedContainer" class="easyui-dialog" buttons="#formSeedButtons"
				style="width:800px; height:400px; padding:10px 20px" closed="true">
			<form id="formSeed" method="POST" novalidate>
				<table class='tbledit'>
					<tr>
						<td>ID：</td>
						<td>
							<input id="id" name="id" required="true" class="easyui-numberbox" readonly="readonly" value="0">
						</td>
						<td>种子ID：</td>
						<td>
							<input name="cId" required="true" class="easyui-numberbox" 
							onkeyup="this.value=this.value.replace(/\D/g,'')" 
							onafterpaste="this.value=this.value.replace(/\D/g,'')">
						</td>
					</tr>
					<tr>
						<td>种子名称：</td>
						<td>
							<input name="caption" required="true" class="easyui-textbox">
						</td>
						<td>X季作物：</td>
						<td>
							<input name="harvestNum" required="true" class="easyui-numberbox">
						</td>
					</tr>
					<tr>
						<td>种子等级：</td>
						<td>
							<input name="cropLevel" required="true" class="easyui-numberbox">
						</td>
						<td>种子类别：</td>
						<td>
							<input name="type" required="true" class="easyui-combobox" panelHeight="auto" 
							data-options="editable:false, valueField:'code', textField:'caption', 
							url:'<%=basePath%>/codeSeedType/data'">
                        </td>
					</tr>
					<tr>
						<td>可获经验：</td>
						<td>
							<input name="exp" required="true" class="easyui-numberbox">
						</td>
						<td>每季成熟所需时间：</td>
						<td>
							<input name="matureTime" required="true" class="easyui-numberbox ">秒
						</td>
					</tr>
					<tr>
						<td>每季成熟可获收成：</td>
						<td>
							<input name="output" required="true" class="easyui-numberbox ">个果实
						</td>
						<td>种子采购价：</td>
						<td>
							<input name="price" required="true" class="easyui-numberbox ">个金币
						</td>
					</tr>
					<tr>
						<td>每个收获的果实单价：</td>
						<td>
							<input name="price4UnitSale" required="true" class="easyui-numberbox">个金币
						</td>
						<td>土地需求：</td>
						<td>
							<input name="landRequirement" required="true" class="easyui-combobox" 
							panelHeight="auto" data-options="editable:false,valueField:'code', textField:'caption',
                                    url:'<%=basePath%>/codeLandRequire/data'">
                        </td>
					</tr>
					<tr>
						<td>每季成熟可获积分：</td>
						<td>
							<input name="score" required="true" class="easyui-numberbox ">
						</td>
						<td>提示信息：</td>
						<td>
							<input name="tip" class="easyui-textbox" required="true" class="text">
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="formSeedButtons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveForm()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#formSeedContainer').dialog('close')">取消</a>
		</div>
		
		<div id="StatusContainer" class="easyui-window" scrolling="no" closed="true"
			style="width:1000px; height:500px; padding:10px 20px">
			<iframe id="iframe" scrolling="no" frameborder="0" width="98%" height="98%"></iframe>
		</div>
		
		<script>
			var grid;
			var seedTypeList;
			var landRequireList;
			var cId = 1;
			var params =
			{
				id: '',
				mode: 'insert'
			};
			$(document).ready(function()
			{
				$(window).resize(function()
				{
					$('#seedListGrid').datagrid('resize', 
					{
						width: $(window).width()-10,
						height: $(window).height()-40
					});
				});
				
				function fixWidth(percent)
				{
					return document.body.clientWidth * percent;
				}
				
				grid = $('#seedListGrid').edatagrid({
						title: '种子清单',
						method: 'post',
						url: '<%=basePath%>/seed/data',
						saveUrl: '<%=basePath%>/seed/save',
						updateUrl: '<%=basePath%>/seed/save',
						destroyUrl: '<%=basePath%>/seed/delete',
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
						pageSize: 5,
						pageList: [5, 10, 15, 20],
						columns: [[
							{
								field: 'id',
								title: 'ID',
								width: fixWidth(0.04),
								sortable: true,
								align: 'center',
								halign: 'center'
							},
							{
								field: 'cId',
								title: '种子ID',
								width: 50,
								width: fixWidth(0.04),
								sortable: true,
								align: 'center',
								halign: 'center'
							},
							{
								field: 'caption',
								title: '种子名称',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center'
							},
							{
								field: 'harvestNum',
								title: 'X季作物',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center',
								formatter: function (value, row)
								{
									return value + "季作物";
			                    }
							},
							{
								field: 'cropLevel',
								title: '种子等级',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center',
								formatter: function (value, row)
								{
									return value + "级作物";
			                    }
							},
							{
								field: 'type',
								title: '种子类别',
								width: fixWidth(0.04),
								sortable: true,
								align: 'center',
								halign: 'center',
								formatter: function (value, row)
								{
									return fromCode2Caption(value, seedTypeList);
			                    }
							},
							{
								field: 'exp',
								title: '可获经验',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center'
							},
							{
								field: 'matureTime',
								title: '每季成熟所需时间',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center',
								formatter: function (value, row)
								{
									return value + "秒";
			                    }
							},
							{
								field: 'output',
								title: '每季成熟可获收益',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center'
							},
							{
								field: 'price',
								title: '种子采购价',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center',
								formatter: function (value, row)
								{
									return value + "金币";
			                    }
							},
							{
								field: 'price4UnitSale',
								title: '每个收获的果实售价',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center',
								formatter: function (value, row)
								{
									return value + "金币";
			                    }
							},
							{
								field: 'landRequirement',
								title: '土地需求',
								width: fixWidth(0.04),
								sortable: true,
								align: 'center',
								halign: 'center',
								formatter: function (value, row)
								{
									return fromCode2Caption(value, landRequireList);
			                    }
							},
							{
								field: 'score',
								title: '每季成熟可获积分',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center',
								formatter: function (value, row)
								{
									return value + "分";
			                    }
							},
							{
								field: 'tip',
								title: '提示信息',
								width: fixWidth(0.08),
								sortable: true,
								align: 'center',
								halign: 'center'
							},
							{
								field: 'operate',
								title: '操作',
								align: 'center',
								width: fixWidth(0.08),
								formatter: function(value, row, index)
								{
									var link = '<button href="#" onclick="checkCropGrow(' + row.cId + ')" class="op-linkbutton">成长阶段</button>';
									return link;
								}
							}
						]],
						destroyMsg: {
							norecord: {
								title: '警告',
								msg: '首先需要选中记录，然后在点击删除按钮'
							},
							confirm: {
								title: '确认',
								msg: '是否删除选中记录?'
							}
						},
						onSuccess: function(index, result)
						{
							console.log(result);
							$("#msgBox").text(result.msg);
						},
						onBeforeLoad: function(param)
						{
							getRemoteData('<%=basePath%>/codeSeedType/data', function(data)
							{
								seedTypeList = data;
							});
							getRemoteData('<%=basePath%>/codeLandRequire/data', function(data)
							{
								landRequireList = data;
							});
						},
						onDestroy: function(index, result)
						{
							console.log(result);
							$("#msgBox").text(result.msg);
						}
				});
				
				grid.datagrid('resize', 
				{
					width: $(window).width()-10,
					height: $(window).height()-40
				});
				
				grid.datagrid("getPager").pagination({
					pageSize: 5,
					pageList: [5, 10, 15, 20]
				});
			});

			function doSearch()
			{
				grid.datagrid("load",
				{
					caption: $("#captionSearch").val()
				});
			}

			function addForm()
			{
				$('#formSeedContainer').dialog('open').dialog('center').dialog('setTitle', '添加数据');
				$('#formSeed').form('clear');
				$('#id').numberbox('setValue', 0);
			}
			
			function editForm()
			{
				var row = grid.datagrid('getSelected');
				if(row)
				{
					params.id = row.id;
					params.mode = 'edit';
					$('#formSeedContainer').dialog('open').dialog('setTitle', '编辑数据');
					$('#formSeed').form('load', row);
				}
				else
				{
					alert("请先选择一行数据，然后再尝试点击操作按钮！");
				}
			}

			function saveForm()
			{
				$('#formSeed').form('submit',
				{
					url: '<%=basePath%>/seed/save',
					onSubmit: function(param)
					{
						param.id = params.id;
						param.mode = params.mode;
						return $(this).form('validate');
					},
					success: function(result)
					{
						var result = eval('(' + result + ')');
						if(result.code == 0)
						{
							$('#formSeedContainer').dialog('close');
							grid.datagrid('reload');
						}
						$.messager.show({
							title: "消息",
							msg: result.msg
						});
					}
				});
			}
			
			function checkCropGrow(id)
			{
				cId = id;
				$('#iframe').attr("src", "<%=basePath%>cropsGrow/grid");
				$('#StatusContainer').window('open').window('setTitle', '编辑成长阶段');
			}
		</script>
	</body>
</html>