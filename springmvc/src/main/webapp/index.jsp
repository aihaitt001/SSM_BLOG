<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<html >

<body>
	<h2>Hello World!</h2><br/>
	
	<a href="/springmvc/list">列表</a>
	<a href="/springmvc/add?flag=1">新增</a>
	
	
	<table >
  	<tr valign="top">
    <td>
    	 <form action="/springmvc/login" id="loginForm" method="post">
    	 	
		  <table width="100%" border="0" cellpadding="0" cellspacing="10">
		    <tr>	    			
		    	<td >登录名：<input name="username" id="username" size="20" value="${user.username}"/></td>
		    	<td >密&nbsp;码：<input name="password" id="password" size="20" value="${user.password}"/></td>		    	
		    </tr>
			
			<tr><td align="left" >
			    <input id="login" type="submit" value="登录">
			    </td>
			</tr>
			
		  </table>
		 </form>
	</td>
  </tr>
</table>
</body>
</html>