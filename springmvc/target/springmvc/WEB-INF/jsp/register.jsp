<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>

<script src="/springmvc/js/jquery-3.2.1.js"></script>
<script src="/springmvc/js/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="/springmvc/js/jquery-validation/dist/localization/messages_zh.js"></script>
<script>
$.validator.setDefaults({
    submitHandler: function() {
      alert("提交事件!");
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#signupForm").validate({
	    rules: {
	     
	      username: {
	        required: true,
	        minlength: 2
	      },
	      password: {
	        required: true,
	        minlength: 5
	      },
	      confirm_password: {
	        required: true,
	        minlength: 5,
	        equalTo: "#password"
	      },
	      email: {
	        required: true,
	        email: true
	      }
	    },
	    messages: {
	     
	      username: {
	        required: "请输入用户名",
	        minlength: "用户名必需由两个字母组成"
	      },
	      password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母"
	      },
	      confirm_password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母",
	        equalTo: "两次密码输入不一致"
	      },
	      email: "请输入一个正确的邮箱",
	     
	    }
	});
});
</script>
</head>
<body>
  <table >
  <tr valign="top">
    <td>
    	 <form action="/springmvc/register" id="userForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2"/>
    	 		<input type="hidden" name="admin" value="2"/>
			
		   
		    
		    <p>
		      <label for="username">用户名</label>
		      <input id="username" name="username" type="text">
		    </p><br/>
		    <p>
		      <label for="password">密码</label>
		      <input id="password" name="password" type="text">
		    </p><br/>
		    <p>
		      <label for="confirm_password">验证密码</label>
		      <input id="confirm_password" name="confirm_password" type="text">
		    </p><br/>
		    <p>
		      <label for="email">Email</label>
		      <input id="email" name="email" type="email">
		    </p><br/>
		  
		    <p>
		      <input class="submit" type="submit" value="提交">
		    </p>
		 
		 </form>
	</td>
  </tr>
</table>
</body>
</html>