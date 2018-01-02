<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>用户管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="/springmvc/js/jquery-1.11.0.js"></script>
	<script type="text/javascript">
	$(function(){
	 	   /** 获取上一次选中的部门数据 */
	 	   var boxs  = $("input[type='checkbox'][id^='box_']");
	 	   
	 	  /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	})
	    	
	    	
	 	   /** 删除员工绑定点击事件 */
	 	   $("#delete").click(function(){
	 		   /** 获取到用户选中的复选框  */
	 		   var checkedBoxs = boxs.filter(":checked");
	 		   if(checkedBoxs.length < 1){
	 			   alert("请选择一个需要删除的用户！");
	 		   }else{
	 			   /** 得到用户选中的所有的需要删除的ids */
	 			   var ids = checkedBoxs.map(function(){
	 				   return this.value;
	 			   })
	 			    if( window.confirm("确认要删除吗?")){
	 					   // alert("删除："+ids.get());
	 					   // 发送请求
	 					   window.location = "/springmvc/deleteUser?ids=" + ids.get();

	 			    }
	 		   }
	 	   })
	    })
	</script>
</head>
<body>
<table><tr><td>当前用户：【${sessionScope.user_session.username}】</td></tr></table>
<table align='center' border='1' cellspacing='0'>
	
    <tr><td><input id="delete" type="button" value="删除"/></td></tr>
	<tr>
	    <td>选择</td>
		<td>用户id</td> 
		<td>用户名</td>
		<td>密码</td>
		<td>email</td>
		<td>管理员权限</td>
		<td>注册时间</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${users}" var="user" varStatus="st">
		<tr>		    
		    <td><input type="checkbox" id="box_${user.id}" value="${user.id}"></td>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td >${user.email }</td>
		    <td >${user.admin}</td>
		    <td >${user.createtime}</td>		
            <td ><a href="/springmvc/updateUser?flag=1&id=${user.id }">修改</a></td>
		</tr>
	</c:forEach>
</table>
					  
</body>
</html>
