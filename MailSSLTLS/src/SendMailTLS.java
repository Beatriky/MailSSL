import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMailTLS {

    public static void main(String[] args) {

        final String username = "beamaria1408@gmail.com";
        final String password = "iiiii";
        final String host = "localhost";

        Properties props = new Properties();

        // enable authentication
        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");// TLS Port

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    //override the getPasswordAuthentication method
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to-email@gmail.com"));
            message.setSubject("Hello");
            message.setText("Hello, Hope you are feeling better...");

            Transport.send(message);  //send Message
            System.out.println("Done!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
