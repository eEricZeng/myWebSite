package site.zengguang.home.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import site.zengguang.home.data.EmailMessage;
import site.zengguang.home.service.IHomeService;
import site.zengguang.util.constant.Constant;

@Service("homeService")
public class HomeServiceImpl implements IHomeService{

    private final String SUCCESS="success";
    private final String SUCCESS_TRUE="true";
//    private final String SUCCESS_FALSE="false";
    
    private final String HOST="mail.host";
    private final String PROTOCOL="mail.transport.protocol";
    private final String STMP_AUTH="mail.smtp.auth";
    
    @SuppressWarnings("serial")
    @Override
    public Map<String, Object> sendEmail(Map<String,Object> map) {
        EmailMessage email = getVisitorWrapper(map);
        sendEmail(email);
        return new HashMap<String,Object>(){{
            this.put(SUCCESS, SUCCESS_TRUE);
        }};
    }
    
    /**
     * 邮件发送执行函数.
     * 
     * @param email 邮件信息
     */
    private void sendEmail(EmailMessage email) {
        Properties prop = new Properties();
        prop.setProperty(HOST, email.getEmailHost());
        prop.setProperty(PROTOCOL, email.getProtocol());
        prop.setProperty(STMP_AUTH, "true");
        
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        //session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = null;
        try {
            ts = session.getTransport();
            //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
            ts.connect(prop.getProperty(HOST), email.getFrom(), Constant.serviceEmailPwd);
            //4、创建邮件
            Message message = createSimpleMail(session,email);
            //5、发送邮件
            ts.sendMessage(message, message.getAllRecipients());
        } catch (NoSuchProviderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                ts.close();
            } catch (MessagingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 封装前端发件人信息.
     * 
     * @param map,key[
     *              name:发件人姓名
     *              email:发件人邮件地址
     *              message:邮件信息]
     * @return
     */
    private EmailMessage getVisitorWrapper(Map<String, Object> map) {
        EmailMessage emailMessage = new EmailMessage((String) map.get("email"),(String) map.get("name"));
        emailMessage.setEmailContent((String) map.get("message"));
        return emailMessage;
    }

    /**
     * 创建一封只包含文本的邮件.
     * 
     * @param session
     * @param email 邮件信息
     * @return
     * @throws AddressException
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private MimeMessage createSimpleMail(Session session, EmailMessage email) throws AddressException, MessagingException, UnsupportedEncodingException{
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(email.getFrom(),email.getFromName()));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
        //邮件的标题
        message.setSubject(email.getEmailSubject());
        //发送日期
        message.setSentDate(new Date());
        //邮件的文本内容
        message.setContent(email.getEmailContent(), "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
     }

}
