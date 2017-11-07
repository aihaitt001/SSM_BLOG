package springmvc.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserService;


@Controller

public class UserController {
	@Autowired
	UserService userservice;
	
	
//	  @RequestMapping("/login")
//	  public String login(String flag,@RequestBody User user,HttpServletResponse res ) {
//		
//		  if(flag.equals("1")) {
//			  return "/login";
//		  }
//		  else if(flag.equals("2")) {
//			  String username = user.getUsername();
//			  String password = userservice.checkUsername(username);
//			  System.out.println(password);
//			  if(password==null) {
//				  return "/login";
//			  }
//			  else {
//				   if(password.equals(user.getpassword())) {
//				  return "/list";
//				   }else{
//				  return "/login";
//				   }
//			  
//			  }
//			 
//			  
//		  }else {
//			  System.out.println("flag is null");
//		  }
//		  
//		 return "/login";
//		  
//		  
//	  }
	  @RequestMapping("/list")
	  public ModelAndView list(){
	        ModelAndView mav = new ModelAndView();
	        List<User> users= userservice.list();
	        // 放入转发参数
	        mav.addObject("users", users);
	        
	        mav.setViewName("list");
	        return mav;
	    }
	  /**
	   * 利用form提交请求。
	   * flag 判定是否添加。1：进入 新增页面。2：新增操作，进入列表页面。
	   * 
	   * **/
	  @RequestMapping("/add")
	  public ModelAndView add(String flag,@ModelAttribute User user, ModelAndView mav){
            if(flag!= null) { 
            	if(flag.equals("1")) {
            		mav.setViewName("add");
            	}else {
            		System.out.println(user);
            		userservice.add(user);
            		mav.setViewName("redirect:list");
            	}            	 
            }else {
            	System.out.println("flag =null");
            }	       
	        return mav;
	    }
	  
	  
	  @RequestMapping("/deleteUser")
	  public ModelAndView deleteUser(String ids,ModelAndView mv) {
		  String[] idlist = ids.split(",");
		  for(String id:idlist) {
			  userservice.delete(Integer.valueOf(id));
		  }
		  mv.setViewName("redirect:/list");
		  return mv;
	  }
	  /**
	   * flag为判定是进入更新页面（1）。还是提交更新页面（2）。
	 * 
	   * **/
	  @RequestMapping("/updateUser")
	  public ModelAndView updateUser(String flag, Integer id,@ModelAttribute User user,ModelAndView mv) {
		  if(flag!= null) { 
          	if(flag.equals("1")) {
          		 System.out.println("更新前："+user);
          		 System.out.println("更新前id："+user.getId());
          	// 根据id查询用户
    			User target = userservice.getById(id);
    			// 设置Model数据
    			mv.addObject("user", target);
    			// 返回修改员工页面
    			mv.setViewName("/update");
          	}else if(flag.equals("2")){
          	    // 执行修改操作
          		 System.out.println("更新后id："+user.getId());
          		 System.out.println("更新后："+user);
    			 userservice.update(user);
    			
    			// 设置客户端跳转到查询请求
    			mv.setViewName("redirect:/list");
          		
          	}            	 
          }else {
          	System.out.println("flag =null");
          }	       
		  
		  return mv;
		
	  }
}

