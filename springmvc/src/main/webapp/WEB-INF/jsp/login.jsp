<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<html >
<head>
	<script type="text/javascript" src="/springmvc/js/jquery-1.11.0.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		
	});
	</script>
</head>
<body>
	<h2>login!</h2><br/>
	<p id="user">用户名 </p><br/>
	<table>
	<tr><td>当前用户：【${sessionScope.user_session.username}】</td></tr>
	</table>
	
	
    	 <form action="/springmvc/login" id="loginForm" method="POST">
    	 	
		 	    		 <label id="message" type="hidden" text="${message}" >${message}</label>
		         <input type="hidden" name="flag" value="2">	
		    	登录名：<input name="username" id="username" size="20" value="${user.username}"/>
		    	密&nbsp;码：<input name="password" id="password" size="20" value="${user.password}"/>		    	
		        
		   
			
						    <input id="login" type="submit" value="登录">			  				 
		 </form>
	
</body>
</html>