package com.lgc.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lgc.pojo.User;
import com.lgc.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger =Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;
   
    @RequestMapping("/getUserinfo")
    @ResponseBody
    public ModelAndView getUserinfo(@RequestParam(value="userName")String userName,Model model){
		User user = userService.findByName(userName);
		model.addAttribute("user",user);
    	if(null == user){
    		return new ModelAndView("error");
    	}
    	System.out.println("用户姓名》》》》》"+user.getUserName());
    	logger.info("用户姓名》》》》》"+user.getUserName());
    	return new ModelAndView("login");
    	
    }
}