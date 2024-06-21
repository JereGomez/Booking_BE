package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailService {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    private Properties mProps;
    private Session mSession;
    private MimeMessage mCorreo;
    //@Value("email.username")
    private String email = "gotravel.alojamientos@gmail.com";
    // @Value("email.password")
    private String password = "dbtq rkhn xxga cdnb";

    @Autowired
    public MailService() {
        mProps = new Properties();
        mProps.put("mail.smtp.host", "smtp.gmail.com");
        mProps.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProps.setProperty("mail.smtp.starttls.enable", "true");
        mProps.setProperty("mail.smtp.port", "587");
        mProps.setProperty("mail.smtp.user", email);
        mProps.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProps.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProps);
    }

    public String getEmail() {
        LOGGER.info(email);
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        LOGGER.info(password);
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void send(String to, String sub, String msg) throws MessagingException {
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(email));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mCorreo.setSubject(sub);
            mCorreo.setText(msg, "ISO-8859-1", "html");

            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(email, password);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            //get Session
        } catch (MessagingException ex) {
            throw new MessagingException(ex.getMessage());
        }
    }
}
