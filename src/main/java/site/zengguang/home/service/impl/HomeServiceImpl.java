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
import javax.mail.internet.MimeUtility;

import org.springframework.stereotype.Service;

import site.zengguang.home.data.EmailMessage;
import site.zengguang.home.service.IHomeService;
import site.zengguang.util.constant.Constant;

@Service("homeService")
public class HomeServiceImpl implements IHomeService{

    private final String SUCCESS="success";
    private final String SUCCESS_TRUE="true";
    private final String SUCCESS_FALSE="false";
    
    private final String HOST="mail.host";
    private final String PROTOCOL="mail.transport.protocol";
    private final String STMP_AUTH="mail.smtp.auth";
    private final String MAIL_FACTORY_CLASS = "mail.smtp.socketFactory.class";
    private final String MAIL_FACTORY_FALLBACK = "mail.smtp.socketFactory.fallback";
    private final String PORT = "mail.smtp.port";
    private final String FACTORY_PORT = "mail.smtp.socketFactory.port";
    private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    
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
    @SuppressWarnings("serial")
    @Override
    public Map<String, Object> emailService(Map<String, Object> map) {
        Boolean isSendAdmin = sendEmailToAdmin(getAdminWrapper(map));
        Boolean isSendVistor = sendEmailToVisitor(getVisitorWrapper(map));
        if(isSendAdmin&&isSendVistor) {
            return new HashMap<String,Object>(){{
                this.put(SUCCESS,SUCCESS_TRUE);
            }};
        }
        return new HashMap<String,Object>(){{
            this.put(SUCCESS, SUCCESS_FALSE);
        }};
    }
    
    /**
     * 向管理员发送访问用户发过来的消息.
     * 
     * @param email
     * @return
     */
    private Boolean sendEmailToAdmin(EmailMessage adminWrapper) {
        sendEmail(adminWrapper);
        return true;
    }

    /**
     * 向访问用户发送邮件，告知用户已收到消息.
     * 
     * @param visitorWrapper
     * @return
     */
    private Boolean sendEmailToVisitor(EmailMessage visitorWrapper) {
        sendEmail(visitorWrapper);
        return true;
    }

    /**
     * 封装前端发件人信息发给管理员.
     * 
     * @param map,key[
     *              name:发件人姓名
     *              email:发件人邮件地址
     *              message:邮件信息]
     * @return
     */
    private EmailMessage getAdminWrapper(Map<String, Object> map) {
        String visitorName = (String) map.get("name");
        String visitorEmail = (String) map.get("email");
        String visitorMessage = (String) map.get("message");
        String adminName = "administrator";
        EmailMessage emailMessage = new EmailMessage(Constant.adminEmail,adminName);
        emailMessage.setEmailSubject("来自网站访问用户"+visitorName+"的邮件");
        StringBuffer content = new StringBuffer();
        content.append("邮件来自：");
        content.append(visitorEmail);
        content.append("<br>");
        content.append("邮件内容：");
        content.append(visitorMessage);
        emailMessage.setEmailContent(content.toString());
        return emailMessage;
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
        String visitorName = (String) map.get("name");
        String visitorEmail = (String) map.get("email");
        EmailMessage emailMessage = new EmailMessage(visitorEmail,visitorName);
        StringBuffer content = new StringBuffer();
        content.append("Dear ");
        content.append(visitorName);
        content.append(",<br>");
        content.append(Constant.defaultContent);
        emailMessage.setEmailContent(content.toString());
        return emailMessage;
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
        // 如果设置,指定实现javax.net.SocketFactory接口的类的名称,这个类将被用于创建SMTP的套接字。
        prop.setProperty(MAIL_FACTORY_CLASS, SSL_FACTORY);
        // 如果设置为true,未能创建一个套接字使用指定的套接字工厂类将导致使用java.net.Socket创建的套接字类。默认值为true。
        prop.setProperty(MAIL_FACTORY_FALLBACK, "false");
        prop.setProperty(PORT, "465");
        // 指定的端口连接到在使用指定的套接字工厂。如果没有设置,将使用默认端口。
        prop.setProperty(FACTORY_PORT, "465");
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
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {
            try {
                ts.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
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
        message.setFrom(new InternetAddress(email.getFrom(),MimeUtility.encodeWord(email.getFromName(),"UTF-8","Q")));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
        //邮件的标题
        message.setSubject(MimeUtility.encodeWord(email.getEmailSubject(),"UTF-8","Q"));
        //发送日期
        message.setSentDate(new Date());
        //邮件的文本内容
        message.setContent(email.getEmailContent(), "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
     }

}
