package com.aryan.email;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {

    public static void send(String to, String subject, String msg) throws Exception {

        final String from = "chaurasiyasandeep9140@gmail.com";     // <-- change
        final String appPass = "wkmiilznrxxuzvws";     // <-- Gmail App Password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, appPass);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(msg);

        Transport.send(message);
    }
}