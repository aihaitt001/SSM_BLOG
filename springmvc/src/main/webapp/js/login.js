
function login(){
	var loginning = check_loginning();
	//alert("loginning:"+loginning);
	if(loginning == "true"){
		$("#log_out").click(function(){
			log_out();
		});
	}
}

function check_loginning(){
	var loginning = "false";
	$.ajax({
		 type: "POST",
		 contentType : 'application/json;charset=utf-8',
            url: "/springmvc/check_loginning" ,
              
            dataType: 'text', //返回数据类型
            success: function (response) {
            	//alert("response:"+response);  
            	if(response == "false"){
            	//	alert("未登录");
            		$("#logout").html("");
            		loginning =  "false";
            	}else{
            	//	alert("已登录");
            		$("#login_a").html(" <a  href=\"/springmvc/user\">"+response+"</a>");
            		$("#logout").html("<a id=\"log_out\" href=\"/springmvc/log_out\">注销</a>")
            		loginning =  "true";
            	}
            	
            	
            },
            error: function (e) {
                alert("error:"+e);
                loginning =  "false";
            }
	});
	return loginning;
}

function log_out(){
	var result = "注销成功";
	$.ajax({
		 type: "POST",
		 contentType : 'application/json;charset=utf-8',
	       url: "/springmvc/log_out" ,
	         
	       dataType: 'text', //返回数据类型
	       success: function (response) {
	    	  // window.location="/springmvc/articles";
	    	   console.log("response:"+response);  
	    	   if(response == "注销成功"){
	    		   window.location.href="/springmvc/articles";
	    			$("#logout").html("");
	    			result = "注销成功" ;
	    	   }	      else{
	    		   result = "注销失败" ;
	    	   } 	         		       
	      
	       },
	       error: function (e) {
	           alert("error:"+e);
	           result = "注销失败" ;
	       }
	});
	return result;
}

