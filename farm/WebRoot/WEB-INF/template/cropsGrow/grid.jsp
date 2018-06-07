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
		<div id="controlBox">
			<a href="#" class="easyui-linkbutton c2" iconCls="icon-add" onclick="addForm()">添加</a>
			<a href="#" class="easyui-linkbutton c4" iconCls="icon-edit" onclick="editForm()">编辑</a>
			<a href="#" class="easyui-linkbutton c3" iconCls="icon-cancel" onclick="javascript:grid.edatagrid('cancelRow')">取消</a>
			<a href="#" class="easyui-linkbutton c5" iconCls="icon-remove" onclick="javascript:grid.edatagrid('destroyRow')">删除</a>
		</div>
		
		<table id="cropsGrowGrid"></table>
		
		<div id="msgBox"></div>
		
		<div id="formCropsGrowContainer" class="easyui-dialog" buttons="#formCropsGrowButtons"
				style="width:750px; height:360px; padding:10px 20px" closed="true">
			<form id="formCropsGrow" method="POST" novalidate>
				<table class='tbledit'>
					<tr>
						<td>ID：</td>
						<td>
							<input id="id" name="id" required="true" class="easyui-numberbox" readonly="readonly" value="0">
						</td>
						<td style="padding-left:30px;">种子ID：</td>
						<td>
							<input name="cId" required="true" class="easyui-numberbox" 
							onkeyup="this.value=this.value.replace(/\D/g,'')" 
							onafterpaste="this.value=this.value.replace(/\D/g,'')">
						</td>
					</tr>
					<tr>
						<td>生长阶段：</td>
						<td>
							<input name="growStep" required="true" class="easyui-numberbox">
						</td>
						<td style="padding-left:30px;">生长阶段标题：</td>
						<td>
							<input name="growCaption" required="true" class="easyui-textbox w100">
						</td>
					</tr>
					<tr>
						<td>阶段生长时间：</td>
						<td>
							<input name="growTime" required="true" class="easyui-numberbox">秒
						</td>
						<td style="padding-left:30px;">生虫概率：</td>
						<td>
							<input name="insect" required="true" class="easyui-numberbox" precision="1" max="1">
                        </td>
					</tr>
					<tr>
						<td>图片宽度：</td>
						<td>
							<input id="width" name="width" required="true" class="easyui-numberbox">px	
						</td>
						<td style="padding-left:30px;">图片高度：</td>
						<td>
							<input id="height" name="height" required="true" class="easyui-numberbox">px
						</td>
					</tr>
					<tr>
						<td>图片offsetX：</td>
						<td>
							<input id="offsetX" name="offsetX" required="true" class="easyui-numberbox">px
						</td>
						<td style="padding-left:30px;">图片offsetY：</td>
						<td>
							<input id="offsetY" name="offsetY" required="true" class="easyui-numberbox">px
						</td>
					</tr>
					<tr>
						<td>作物状态：</td>
						<td>
							<input name="status" required="true" class="easyui-combobox" 
							panelHeight="auto" data-options="editable:false,valueField:'code', textField:'caption',
                                    url:'<%=basePath%>/codeCropStatus/data'">
                        </td>
                        <td colspan="2"  align="right">
                        	<button href="#" type="button" class="op-linkbutton" onclick="editPicture()">编辑图片位置</button>
                        </td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="formCropsGrowButtons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" 
				onclick="saveForm()">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" 
				onclick="javascript:$('#formCropsGrowContainer').dialog('close')">取消</a>
		</div>
		
		<div id="positionDialog" class="easyui-dialog" style="width:240px;height:420px;padding:10px 10px" 
				closed="true" buttons="#positionDialogButtons">
    			<div id="tools-imagePositioner-display" class="tools-imagePositioner-display">
      				<img class="easyui-draggable easyui-resizable" src="" data-options="onDrag:imagePositioneronDrag">
   				</div>
		</div>
		
		<div id="positionDialogButtons">
		    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
		    	onclick="gainPostion()">确定</a>
		    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
		 		onclick="javascript:$('#positionDialog').dialog('close')">取消</a>
		</div>
		
		<script>
			var grid;
			var imgExtData = {};
			var cropStatusList;
			var params =
			{
				id: '',
				mode: 'insert'
			};
			$(document).ready(function()
			{
				$(window).resize(function()
				{
					$('#cropsGrowGrid').datagrid('resize', 
					{
						width: $(window).width()-10,
						height: $(window).height()-40
					});
				});
				
				function fixWidth(percent)
				{
					return document.body.clientWidth * percent;
				}
				
				grid = $('#cropsGrowGrid').edatagrid({
					title: '成长阶段定义',
					method: 'post',
					url: '<%=basePath%>/cropsGrow/data',
					saveUrl: '<%=basePath%>/cropsGrow/save',
					updateUrl: '<%=basePath%>/cropsGrow/save',
					destroyUrl: '<%=basePath%>/cropsGrow/delete',
					queryParams: {"cId": window.parent.cId},
					border: false,
					rownumbers: true,
					remoteSort: true,
					nowrap: false,
					singleSelect: true,
					fitColumns: true,
					pagination: false,
					striped: true,
					autoSave: true,
					idField: "id",
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
							field: 'growStep',
							title: '成长阶段',
							width: fixWidth(0.08),
							sortable: true,
							align: 'center',
							halign: 'center'
						},
						{
							field: 'growCaption',
							title: '生长阶段标题',
							width: fixWidth(0.08),
							sortable: true,
							align: 'center',
							halign: 'center'
						},
						{
							field: 'growTime',
							title: '阶段生长时间',
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
							field: 'insect',
							title: '生虫概率',
							width: fixWidth(0.04),
							sortable: true,
							align: 'center',
							halign: 'center'
						},
						{
							field: 'width',
							title: '宽度',
							width: fixWidth(0.08),
							sortable: true,
							align: 'center',
							halign: 'center',
							formatter: function (value, row)
							{
								return value + "px";
		                    }
						},
						{
							field: 'height',
							title: '高度',
							width: fixWidth(0.08),
							sortable: true,
							align: 'center',
							halign: 'center',
							formatter: function (value, row)
							{
								return value + "px";
		                    }
						},
						{
							field: 'offsetX',
							title: '每季成熟可获收益',
							width: fixWidth(0.08),
							sortable: true,
							align: 'center',
							halign: 'center',
							formatter: function (value, row)
							{
								return value + "px";
		                    }
						},
						{
							field: 'offsetY',
							title: '种子采购价',
							width: fixWidth(0.08),
							sortable: true,
							align: 'center',
							halign: 'center',
							formatter: function (value, row)
							{
								return value + "px";
		                    }
						},
						{
							field: 'status',
							title: '作物状态',
							width: fixWidth(0.08),
							sortable: true,
							align: 'center',
							halign: 'center',
							formatter: function (value, row)
							{
								return fromCode2Caption(value, cropStatusList);
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
						getRemoteData('<%=basePath%>/codeCropStatus/data', function(data)
						{
							cropStatusList = data;
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
			});
			
			function addForm()
			{
				$('#formCropsGrowContainer').dialog('open').dialog('center').dialog('setTitle', '添加数据');
				$('#formCropsGrow').form('clear');
				$('#id').numberbox('setValue', 0);
			}
			
			function editForm()
			{
				var row = grid.datagrid('getSelected');
				if(row)
				{
					params.id = row.id;
					params.mode = 'edit';
					$('#formCropsGrowContainer').dialog('open').dialog('center').dialog('setTitle', '编辑数据');
					$('#formCropsGrow').form('load', row);
				}
				else
				{
					alert("请先选择一行数据，然后再尝试点击操作按钮！");
				}
			}

			function saveForm()
			{
				$('#formCropsGrow').form('submit',
				{
					url: '<%=basePath%>/cropsGrow/save',
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
							$('#formCropsGrowContainer').dialog('close');
							grid.datagrid('reload');
						}
						$.messager.show({
							title: "消息",
							msg: result.msg
						});
					}
				});
			}
			
			function editPicture()
			{
				var src = '<%=basePath%>/images/crops/';
				var cId = $("input[name='cId']").val();
				var growStep = $("input[name='growStep']").val();
				if (growStep == 0)
				{
					src += 'basic/0.png';
				}
				else if(growStep == 6)
				{
					src += 'basic/9.png';
				}
				else
				{
					src += cId + '/' + growStep + '.png';
				}
				draggableImg.attr("src", src);
				imgExtData.width = $("input[name='width']").val();
				imgExtData.height = $("input[name='height']").val();
				imgExtData.offsetX = $("input[name='offsetX']").val();
				imgExtData.offsetY = $("input[name='offsetY']").val();
				$('#positionDialog').dialog('open').dialog('center').dialog('setTitle', '定位编辑器');
				positionerLoadImage();
			}
			
			function gainPostion()
			{
		    	$("#width").numberbox('setValue', draggableImg.width());
		    	$("#height").numberbox('setValue', draggableImg.height());
		    	$("#offsetX").numberbox('setValue', draggableImg.position().left);
		    	$("#offsetY").numberbox('setValue', draggableImg.position().top);
		    	$('#positionDialog').dialog('close');
		    }
			
			function imagePositioneronDrag(e)
			{
				var d = e.data;
				if (d.left < 0)
				{
					d.left = 0
				}
				if (d.top < 0)
				{
					d.top = 0
				}
				if (d.left + $(d.target).outerWidth() > $(d.parent).width())
				{
					d.left = $(d.parent).width() - $(d.target).outerWidth();
				}
				if (d.top + $(d.target).outerHeight() > $(d.parent).height())
				{
					d.top = $(d.parent).height() - $(d.target).outerHeight();
				}
			}
		</script>
	</body>
</html>