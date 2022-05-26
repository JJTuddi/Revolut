package com.app.banking.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.stereotype.Service;

//import javax.mail.*;
//import javax.mail.internet.*;
//import java.io.IOException;
//import java.util.Date;

@Service
public class EmailService {

    public void sendEmail(){
        // Recipient's email ID needs to be mentioned.
        String to = "alexandrapatica@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "appbanking079@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("appbanking079@gmail.com", "nyvnigfbcnjubblf");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.host", "smtp.gmail.com");
//        props.put("mail.username", "appbanking079@gmail.com");
//        props.put("mail.password", "nyvnigfbcnjubblf");
//        props.put("mail.port", "587");
//
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("appbanking079@gmail.com", "nyvnigfbcnjubblf");
//            }
//        });
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress("appbanking079@gmail.com", false));
//
//        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("alexandrapatica@gmail.com"));
//        msg.setSubject("Tutorials point email");
//        msg.setContent("Tutorials point email", "text/html");
//        msg.setSentDate(new Date());
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent("Tutorials point email", "text/html");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//        MimeBodyPart attachPart = new MimeBodyPart();
//
//        attachPart.attachFile("util/lion.png");
//        multipart.addBodyPart(attachPart);
//        msg.setContent(multipart);
//        Transport.send(msg);
    }
}
