package site.zengguang.home.data;

import java.util.Date;

import site.zengguang.util.constant.Constant;

/**
 * 发送邮件需要基本信息类.
 */
public class EmailMessage {
    // 邮件接收者
    private String to;
 
    // 收件人姓名
    private String toName;
    
    // 邮件发送人
    private String from = Constant.serviceEmail;
     
    // 发送人姓名
    private String fromName = Constant.serviceEmailName;
 
    // 抄送者   
//    private String cc="549373335@qq.com";      
 
    // 暗送者
//    private String bcc="postmaster@zengguang.site";   
 
    // 邮件类型
    private String emailContent = Constant.defaultContent;
 
    // 邮件主题
    private String emailSubject = Constant.defaultSubject;  
 
    // 邮件头
    private String emailHeader = "This Is Email Header";
 
    // 邮件内容
//    private String emailBody = "<a href=\"http://www.baidu.com\">This Is Email Body</a>";
 
    // 使用邮箱服务器 
    private String emailHost = "smtp.mxhichina.com";
    
    // 邮件协议
    private String protocol = "smtp";
 
    // 邮件发送日期
    public static Date getDate = new Date();
    
    /**
     * 构造函数.
     * 
     * @param to 收件人地址
     * @param toName 收件人姓名
     */
    public EmailMessage(String to,String toName) {
        this.to = to;
        this.toName = toName;
    }

    public String getTo() {
        return to;
    }

    public String getToName() {
        return toName;
    }

    public String getFrom() {
        return from;
    }
    
    public String getFromName() {
        return fromName;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailHeader() {
        return emailHeader;
    }

    public void setEmailHeader(String emailHeader) {
        this.emailHeader = emailHeader;
    }

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

}