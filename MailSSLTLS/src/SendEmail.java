import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
//acesta este un prototip-nu trebuie bagat in seama
    public static void main(String[] args) {

        String to = "got@gmail.com";
        String from = "beamaria1408@gmail.com";
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        // composing the mail
        try {
            MimeMessage message = new MimeMessage(session);

            // headerul pentru mail
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("subject-HRU");
            message.setText("Hello, Hope you are well ");
            Transport.send(message);
            System.out.println("EMAIL SENT SUCCESFULLY!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
