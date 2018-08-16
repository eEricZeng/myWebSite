package site.zengguang.home.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.zengguang.home.service.IHomeService;

@Controller
@RequestMapping(value="/home")
public class HomePageController {
    
    @Autowired
    private IHomeService homeService;
    
    @RequestMapping(value="/email", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendEmail(@RequestParam Map<String,Object> map){
        return homeService.sendEmail(map);
    }
}
