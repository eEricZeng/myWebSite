package site.zengguang.util.constant;

import site.zengguang.util.conf.ReadConfig;

/**
 * 常量类。
 * 
 * @author zengguang
 *
 */
public class Constant {

    /** 网站邮箱地址 **/
    public static String serviceEmail = ReadConfig.getString("service_email");

    /** 网站邮箱密码 **/
    public static String serviceEmailPwd = ReadConfig.getString("service_email_pwd");

    /** 网站发件人名字 **/
    public static String serviceEmailName = ReadConfig.getString("service_email_name");

    /** 默认回复邮件主题 **/
    public static String defaultSubject = ReadConfig.getString("default_subject");

    /** 默认回复邮件内容 **/
    public static String defaultContent = ReadConfig.getString("default_content");

    /** 网站管理员邮箱 **/
    public static String adminEmail = ReadConfig.getString("admin_email");

    /** 图灵问答接口 **/
    public static final String TULING_URL = ReadConfig.getString("tuling_url");

    /** 图灵机器人aipkey **/
    public static final String APIKEY = ReadConfig.getString("apikey");

    /**
     * 禁用工具类构造方法.
     */
    private Constant() {
    }
}
