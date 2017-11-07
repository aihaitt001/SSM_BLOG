<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">

</script>

<title>login</title>

</head>
<body>
  <table >
  <tr valign="top">
    <td>
    	 <form action="/springmvc/login" id="loginForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10">
		    <tr><td>
		    	<table>
		    		<tr>		    			
		    			<td >登录名：<input name="username" id="username" size="20" /></td>
		    			<td >密&nbsp;码：<input name="password" id="password" size="20" /></td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			
			<tr><td align="left" >
			    <input id="login" type="submit" value="登录">
			    </td>
			</tr>
			<tr>
			    <p id="loginresult"></p>
			</tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
</body>
</html>