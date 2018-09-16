package site.zengguang.home.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.zengguang.home.service.IHomeService;
import site.zengguang.util.security.FormValidator;

@Controller
@RequestMapping(value="/home")
public class HomePageController {
    
    @Autowired
    private IHomeService homeService;
    
    /**
     * 封装并转发用户邮件消息.
     * 
     * @param map,key[
     *              email: 用户邮箱地址,
     *              message: 用户邮件消息,
     *              name: 用户姓名]
     * @return
     */
    @RequestMapping(value="/email", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendEmail(@RequestParam Map<String,Object> map){
        if(FormValidator.checkSpecialStr(map.toString())) {
            return null;
        }
        return homeService.emailService(map);
    }
}
