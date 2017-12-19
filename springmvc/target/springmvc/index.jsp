<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<html >

<body>
	<h2>Hello World!</h2><br/>
	
	<ul>
	<li><a href="/springmvc/login">登陆</a></li>
	<li><a href="/springmvc/register">注册</a></li>
	<li><a href="/springmvc/listUser">列表</a></li>
	<li><a href="/springmvc/addUser?flag=1">新增</a></li>
	<li><a href="/springmvc/artcles">文章</a></li>
	
	<li><form id="_form" method="post" action="/springmvc/artcles">
  <input type="hidden" name="flag" value="1" /> 
  <a onclick="document.getElementById('_form').submit();">写作</a>
</form></li>
	</ul>
	<table>
  	<tr valign="top">
    <td>
    	 <form action="/springmvc/login" id="loginForm" method="POST">
    	 	
		  <table width="100%" border="0" cellpadding="0" cellspacing="10">
		    <tr>	    		
		         <input type="hidden" name="flag" value="2">	
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