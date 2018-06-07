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
		<div style="width:100%;height:800px;">
			<div id="w" class="easyui-window" noheader=true collapsible=false minimizable=false 
				maximizable=false scrolling="no" style="width:81%;height:455px;padding:10px;">
				<div id="controlBox">
					<span style="color:white">用户名:</span>
					<input id="nameSearch" class="easyui-textbox" panelHeight="auto">
					<a href="#" class="easyui-linkbutton c1" iconCls="icon-search" onclick="doSearch()">查询</a>
					<a href="#" class="easyui-linkbutton c2" iconCls="icon-add" onclick="addForm()">添加</a>
					<a href="#" class="easyui-linkbutton c3" iconCls="icon-cancel" onclick="javascript:grid.edatagrid('cancelRow')">取消</a>
					<a href="#" class="easyui-linkbutton c5" iconCls="icon-remove" onclick="javascript:grid.edatagrid('destroyRow')">删除</a>
				</div>
					
				<table id="userGrid"></table>
				
				<div id="msgBox" class="easyui-dialog" buttons="#confirm"
						style="width:300px; height:150px; padding:10px 20px" closed="true">
					<div id="confirm">
						<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#msgBox').dialog('close')">关闭窗口</a>
					</div>
				</div>
				
				<div id="formUserContainer" class="easyui-dialog" buttons="#formUserButtons"
						style="width:580px; height:250px; padding:10px 20px" closed="true">
					<form id="formUser" method="POST" novalidate>
						<table class='tbledit'>
							<tr>
								<td>ID：</td>
								<td>
									<input id="id" name="id" required="true" class="easyui-numberbox" readonly="readonly" value="0">
								</td>
								<td style="padding-left:50px;">头像：</td>
								<td>
									<input name="headImg" required="true" class="easyui-textbox">
								</td>
							</tr>
							<tr>
								<td>用户名：</td>
								<td>
									<input name="name" required="true" class="easyui-textbox">
								</td>
								<td style="padding-left:50px;">昵称：</td>
								<td>
									<input name="nickName" required="true" class="easyui-textbox">
								</td>
							</tr>
							<tr>
								<td>经验值：</td>
								<td>
									<input name="exp" required="true" class="easyui-numberbox">
								</td>
								<td style="padding-left:50px;">积分：</td>
								<td>
									<input name="score" required="true" class="easyui-numberbox">
		                        </td>
							</tr>
							<tr>
								<td>金币：</td>
								<td>
									<input name="goldCoin" required="true" class="easyui-numberbox">
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:$('#w').dialog('close')" style="width:80px">关闭</a>
				</div>
			</div>
		</div>
		
		<div id="formUserButtons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveForm()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#formUserContainer').dialog('close')">关闭窗口</a>
		</div>
		
		<div id="uploadContainer" class="easyui-dialog" buttons="#formUploadButtons" closed="true"
				style="width:450px; height:110px; padding:10px 20px" title="">
			<form id="uploadForm" method="POST" enctype="multipart/form-data">
				<table class='tbledit'>
					<tr>
						<td>头像文件：</td>
						<td>
							<input id="file1" name="filePathName" class="easyui-filebox" style="width:300px;" 
							data-options="prompt:'请先选择文件需要上传的文件...',buttonText:'选择文件'">
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="formUploadButtons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="uploadHeadImg()">开始上传</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#uploadContainer').dialog('close')">关闭窗口</a>
		</div>
		
		<script>
			var params =
			{
				id: '',
				mode: 'insert'
			};
			$(document).ready(function()
			{
				$(window).resize(function()
				{
					$('#userGrid').datagrid('resize', 
					{
						width: $(window).width()-10,
						height: $(window).height()-40
					});
				});
				
				function fixWidth(percent)
				{
					return document.body.clientWidth * percent;
				}
				
				grid = $('#userGrid').edatagrid({
						title: '用户清单',
						method: 'post',
						url: '<%=basePath%>/user/data',
						saveUrl: '<%=basePath%>/user/save',
						updateUrl: '<%=basePath%>/user/save',
						destroyUrl: '<%=basePath%>/user/delete',
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
								width: fixWidth(0.125),
								sortable: true,
								align: 'center',
								halign: 'center'
							},
							{
								field: 'headImg',
								title: '头像',
								width: fixWidth(0.2),
								align: 'center',
								halign: 'center',
								editor:
								{
			                        type:'textbox'
			                    },
			                    formatter:function(value, row)
			                    {
			                    	if(value == null)
			                    		value="none.jpg";
			                      	return '<img src="<%=basePath%>/images/headImages/' + value + '" width="100px">';
			                    }
							},
							{
								field: 'name',
								title: '用户名',
								width: fixWidth(0.15),
								sortable: true,
								align: 'center',
								halign: 'center',
								editor:
								{
			                        type:'validatebox',
			                        options: 
			                        {                         
			                            validType:'length[1,20]',                            
			                            invalidMessage:'有效长度1-20',
			                            required:true
			                        }
			                    }
							},
							{
								field: 'nickName',
								title: '昵称',
								width: fixWidth(0.125),
								sortable: true,
								align: 'center',
								halign: 'center',
								editor:
								{
			                        type:'validatebox',
			                        options: 
			                        {                         
			                            validType:'length[1,20]',                            
			                            invalidMessage:'有效长度1-20',
			                            required:true
			                        }
			                    }
							},
							{
								field: 'exp',
								title: '经验值',
								width: fixWidth(0.25),
								sortable: true,
								align: 'center',
								halign: 'center',
								editor:
								{
			                        type:'validatebox',
			                        options: 
			                        {                         
			                            validType:'length[1,5]',                            
			                            invalidMessage:'有效长度1-5',
			                            required:true
			                        }
			                    },
								formatter: function (value, row)
								{
									return '<img src="<%=basePath%>/images/exp.png" width="50px">'+value;
			                    }
							},
							{
								field: 'score',
								title: '积分',
								width: fixWidth(0.25),
								sortable: true,
								align: 'center',
								halign: 'center',
								editor:
								{
			                        type:'validatebox',
			                        options: 
			                        {                         
			                            validType:'length[1,5]',                            
			                            invalidMessage:'有效长度1-5',
			                            required:true
			                        }
			                    },
								formatter: function (value, row)
								{
									return '<img src="<%=basePath%>/images/score.png" width="50px">'+value	
			                    }
							},
							{
								field: 'goldCoin',
								title: '金币',
								width: fixWidth(0.25),
								sortable: true,
								align: 'center',
								halign: 'center',
								editor:
								{
			                        type:'validatebox',
			                        options: 
			                        {                         
			                            validType:'length[1,5]',                            
			                            invalidMessage:'有效长度1-5',
			                            required:true
			                        }
			                    },
								formatter: function (value, row)
								{
									return  '<img src="<%=basePath%>/images/gold.png" width="50px">'+value;
			                    }
							},
							{
								field: 'operate',
								title: '操作',
								width: fixWidth(0.3),
								align: 'center',
								formatter: function(value, row, index)
								{
									var link = '<button href="#" onclick="openUploadDialog(' + index + ')" class="op-linkbutton">上传头像</button>';
									link += '<button href="#" onclick="saveData(' + index + ')" class="op-linkbutton">保存数据</button>';
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
							$("#msgBox").dialog('open').dialog('center').dialog('setTitle', 'message').text(result.msg);
						},
						onDestroy: function(index, result)
						{
							console.log(result);
							$("#msgBox").dialog('open').dialog('center').dialog('setTitle','message').text(result.msg);
						}

				});
				
				grid.datagrid('resize', 
				{
					width: $(window).width()*0.8-30,
					height: $(window).height()-150
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
					name: $("#nameSearch").val()
				});
			}

			function addForm()
			{
				$('#formUserContainer').dialog('open').dialog('center').dialog('setTitle', '添加数据');
				$('#formUser').form('clear');
				$('#id').numberbox('setValue', 0);
			}
			
			function saveForm()
			{
				$('#formUser').form('submit',
				{
					url: '<%=basePath%>/user/save',
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
							$('#formUserContainer').dialog('close');
							grid.datagrid('reload');
						}
						$.messager.show({
							title: "消息",
							msg: result.msg
						});
					}
				});
			}
			
			function openUploadDialog(index)
			{
				$('#uploadContainer').dialog('open').dialog('center');
				$('#uploadForm').form('clear');
			}
			
			function uploadHeadImg(index)
			{
				var formData = new FormData($("#uploadForm")[0]);
				$("#uploadForm").form('submit', 
				{
	                type:"post", 
	                url: "<%=basePath%>/file/saveHeadImg",
	                data: formData,
	                contentType: false,
	                success:function(result)
	                {
	                	$('#uploadContainer').dialog('close');
	                	var row = grid.datagrid('getSelected');
	                	var rowIndex = grid.datagrid('getRowIndex', grid.datagrid('getSelected'));
	                	
                        $('#userGrid').datagrid('beginEdit', rowIndex);
                        var ed = $('#userGrid').datagrid('getEditor', {
                        	index:rowIndex,
                        	field:'headImg'
                        });
                        $(ed.target).textbox('setValue', getFileName($("input[name='filePathName']").val()));
	                }
	            });
			}
			
			function saveData(index)
			{
				$('#userGrid').datagrid('endEdit', index);
			}
			
			function getFileName(o)
			{
			    var pos = o.lastIndexOf("\\");
			    return o.substring(pos+1);
			}
		</script>
	</body>
</html>