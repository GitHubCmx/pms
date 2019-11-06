package com.offcn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class TestApp {


    @Test
    public void test01() throws  Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-email.xml");
        JavaMailSenderImpl bean = context.getBean(JavaMailSenderImpl.class);
        //邮件对象
        MimeMessage mimeMessage = bean.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        helper.setFrom("cmx16851005@163.com");
        helper.setTo("2297161903@qq.com");
        helper.setSubject("标题");
        helper.setText("内容");

        //发送邮件
        bean.send(mimeMessage);

        System.out.println("EMAIL PASS");
    }
}

