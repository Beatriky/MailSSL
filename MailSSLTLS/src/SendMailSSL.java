import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMailSSL {
    public static void main(String[] args) {
        String to = "dkjaskdjksladj@gmail.com";
        String from = "beamaria1408@gmail.com";
        String host = "localhost";

        final String username = "beamaria1408@gmail.com";
        final String password = "iii"; //nu pot arata parola

        System.out.println("TLSEmail Start");

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        // SSL Port
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        // SSL Factory
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");


        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication("username",
                                "password"); }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("subject");
            message.setText("Hello, Im sending this email to you because... ");

            // Send message
            Transport.send(message);
            System.out.println("Sent succesfully!");
        } catch (
                MessagingException mex) {
            mex.printStackTrace();
        }
    }
}


