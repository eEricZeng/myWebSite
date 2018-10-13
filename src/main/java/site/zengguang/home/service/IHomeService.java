package site.zengguang.home.service;

import java.util.Map;

/**
 * 首页业务层接口定义。
 * 
 * @author zengguang
 *
 */
public interface IHomeService {
    
    /**
     * 邮件服务.<br>
     * 把邮件信息转发给管理员，并告诉访问用户已经收到消息.
     * 
     * @param map 前端发送的信息,key[
     *                          name: 用户姓名
     *                          email: 邮件发送地址
     *                          message: 发送的邮件消息]
     * @return
     */
    Map<String, Object> emailService(Map<String, Object> map);
}
