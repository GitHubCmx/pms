<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>编辑项目信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/static/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function () {/*客户公司名称*/
		$.ajax({
			type: "GET",
			url: "${pageContext.request.contextPath}/cust/jsonList",
			success: function (msg) {
				$(msg).each(function(index,item){
					var option = "<option value='"+item.id+"'>"+item.comname+"</option>";
					$("#cusList").append(option);
				});
			}
		});
		$.ajax({/*项目经理*/
			type: "GET",
			url: "${pageContext.request.contextPath}/emp/managers",
			success: function (msg) {
				$(msg).each(function(index,item){
					var option = "<option  value='"+item.eid+"'>"+item.ename+"</option>";
					$("#managers").append(option);
				});
			}
		});
	});
	function parseLeader(cid) {/*客户方负责人*/
		$.ajax({
			type: "GET",
			url: "${pageContext.request.contextPath}/cust/info/"+cid,
			success: function (msg) {
				$("#custperson").val(msg.companyperson);
			}
		});

	}
	function commit() {
		$("#form2").submit();
	}
</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>编辑项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form2" action="${pageContext.request.contextPath}/pro/updateProject" method="POST">
     <input type="hidden" name="_method" value="put">
    <input type="hidden" name="${project.pid}">
	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="12" background="/skin/images/tbg.gif">&nbsp;添加新项目信息&nbsp;</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22" >项目名称：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" name="pname" value="${project.pname}"/></td>
			<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select name="comname"  id="cusList" onchange="parseLeader(this.value)">
					<option >${project.customer.comname}</option>
				</select>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" id="custperson" name="comper" readonly value="${project.customer.companyperson}"/></td>
			<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select id="managers"  name="empFk" >
					<option >${project.employee.ename}</option>
				</select>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22" >开发人数：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" name="empcount" value="${project.empcount}"/>人</td>
			<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input name="starttime"  type="text" onClick="WdatePicker()" value="<fmt:formatDate value="${project.starttime}" pattern="yyyy-MM-dd"></fmt:formatDate>" />

			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input name="buildtime"  type="text" onClick="WdatePicker()" value="<fmt:formatDate value="${project.buildtime}" pattern="yyyy-MM-dd"></fmt:formatDate>" />

			</td>
			<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input type="text" name="cost" value="${project.cost}"/>万</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select  name="level">

					<option value="紧急" ${project.level=='紧急'?'selected':''}>紧急</option>
					<option value="一般" ${project.level=='一般'?'selected':''}>一般</option>
					<option value="暂缓" ${project.level=='暂缓'?'selected':''}>暂缓</option>


				</select>
			</td>
			<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input name="endtime"  type="text" onClick="WdatePicker()" value="<fmt:formatDate  value="${project.endtime}" pattern="yyyy-MM-dd" ></fmt:formatDate>"/>


			</td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" >备注：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea type="text" rows=15 cols=130  name="remark">
					${project.remark}
				</textarea><span id="number"></span>
			</td>
		</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
	<a href="javascript:history.go(-1)" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>