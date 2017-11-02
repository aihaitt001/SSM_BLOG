package springmvc.controller;

import java.util.List;

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
	
	  @RequestMapping("/list")
	  public ModelAndView list(){
	        ModelAndView mav = new ModelAndView();
	        List<User> users= userservice.list();
	        // 放入转发参数
	        mav.addObject("users", users);
	        
	        mav.setViewName("list");
	        return mav;
	    }
	  
	  @RequestMapping("/add")
	  public ModelAndView add(String flag,@ModelAttribute User user, ModelAndView mav){
            if(flag!= null) { 
            	if(flag.equals("1")) {
            		mav.setViewName("add");
            	}else {
            		System.out.println(user);
            		userservice.Add(user);
            		mav.setViewName("redirect:list");
            	}            	 
            }else {
            	System.out.println("flag =null");
            }	       
	        return mav;
	    }
	  
	  @RequestMapping("/update")
	  public ModelAndView update(String flag,@ModelAttribute User user, ModelAndView mav){
		
		  
		  
		  return mav;
	  }
}

