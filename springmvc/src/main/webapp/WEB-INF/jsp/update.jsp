<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update</title>
</head>
<body>
  <table >
  <tr valign="top">
    <td>
    	 <form action="/springmvc/updateUser" id="userForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10">
		    <tr><td >
		    	<table>
		    		<tr>
		    		    <td >id:<input name="id" id="id" size="20" value="${user.id} "/></td>
		    		    <td >登录名：<input name="username" id="username" size="20" value="${user.username} "/></td>
		    			<td >密&nbsp;码：<input name="password" id="password" size="20" value="${user.password} "/></td>
		    			<td >邮箱：<input type="text" name="email" id="email" size="20" value="${user.email} "/></td>
		    			<td >是否管理员：<input type="text" name="admin" id="admin" size="20" value="${user.admin} "/></td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			
			<tr><td align="left" >
			    <input type="submit" value="修改">&nbsp;&nbsp;
			    <input type="reset" value="取消 "></td>
			</tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
</body>
</html>