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


}
