package app.service.implementations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImp {

  @Autowired
  private JavaMailSender javaMailSender;

  public void sendMail(String from, String to, String subject, String body) {
    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setFrom(from);
    mail.setTo(to);
    mail.setSubject(subject);
    mail.setText(body);
    javaMailSender.send(mail);
  }

  public void sendMail() {

    SimpleMailMessage mail = new SimpleMailMessage();

    mail.setFrom("decodectech@gmail.com");
    mail.setTo("fas_facu@hotmail.com");
    mail.setSubject("tema");
    mail.setText("cuerpo");

    javaMailSender.send(mail);
  }

  /*
public void enviar() throws MessagingException {
  Properties prop = new Properties();
  prop.put("mail.smtp.auth", true);
  prop.put("mail.smtp.starttls.enable", "true");
  prop.put("mail.smtp.host", "smtp.mailtrap.io");
  prop.put("mail.smtp.port", "25");
  prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

  Session session = Session.getInstance(prop, new Authenticator() {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication("decodextech@gmail.com", "decodex1234");
    }
  });

  Message message = new MimeMessage(session);
  message.setFrom(new InternetAddress("decodextech@gmail.com"));
  message.setRecipients(
    Message.RecipientType.TO, InternetAddress.parse("decodextech@gmail.com"));
  message.setSubject("Mail Subject");

  String msg = "This is my first email using JavaMailer";

  MimeBodyPart mimeBodyPart = new MimeBodyPart();
  mimeBodyPart.setContent(msg, "text/html");

  Multipart multipart = new MimeMultipart();
  multipart.addBodyPart(mimeBodyPart);

  message.setContent(multipart);

  Transport.send(message);
}
*/
}
