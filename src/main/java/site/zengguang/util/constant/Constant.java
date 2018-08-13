package site.zengguang.util.constant;

import site.zengguang.util.conf.ReadConfig;

public class Constant {

    /**网站邮箱地址**/
    public static String serviceEmail = ReadConfig.getString("service_email");
    
    /**网站邮箱密码**/
    public static String serviceEmailPwd = ReadConfig.getString("service_email_pwd");
    
    /**默认回复邮件主题**/
    public static String defaultSubject = ReadConfig.getString("default_subject");
    
    /**默认回复邮件内容**/
    public static String defaultContent = ReadConfig.getString("default_content");
}
