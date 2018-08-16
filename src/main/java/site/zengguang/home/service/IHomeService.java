package site.zengguang.home.service;

import java.util.Map;

public interface IHomeService {
    
    /**
     * 发送电子邮件.
     * 
     * @param map 前端发送的信息,key[
     *                          name: 用户姓名
     *                          email: 邮件发送地址
     *                          message: 发送的邮件消息]
     * @return
     */
    Map<String,Object> sendEmail(Map<String, Object> map);
}
