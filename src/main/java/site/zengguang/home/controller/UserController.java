package site.zengguang.home.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import site.zengguang.home.data.User;
import site.zengguang.home.service.IUserService;

@Controller  
public class UserController {  

    @Resource  
    private IUserService userService; 

    @RequestMapping("/")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index"); 
        User user = userService.selectUserById(1); 
        mav.addObject("user", user); 
        return mav; 
    }    
}  
