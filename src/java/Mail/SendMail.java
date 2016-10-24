/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Kasun Kalhara
 */
public class SendMail {

    public static void main(String[] args) {
//        sendSimpleMail();
    }

    public static int sendingVerificationEmail(String email, String key) {

        String msg = "To confirm your email address click this link. \n http://localhost:8080/WebApplication1/VerifyEmailS?email=" + email + "&key=" + key;
        System.out.println(msg);

        int s = sendSimpleMail(email, msg);
        return s;
    }

    static int sendSimpleMail(String email, String msg) {

        final String username = "donkkrh@gmail.com";
        final String password = "kasun1211";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            System.out.println("start....");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("donkkrh@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Verification Email");
            message.setText(msg);
            Transport.send(message);
            System.out.println("Send....");
            return 1;

        } catch (MessagingException e) {
            e.printStackTrace();
            return 0;
        }
    }

    static int sendingMultipleEmails(String to, String subject, String msg) {

        String username = "donkkrh@gmail.com";
        String password = "kasun1211";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            System.out.println("start....");
            System.out.println(to);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(msg);
            Transport.send(message);
            System.out.println("Send....");
            return 1;

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Send Fail....");
            return 0;
        }
    }

    
    
}
