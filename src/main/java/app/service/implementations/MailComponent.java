package app.service.implementations;

import app.service.interfaces.EmailService;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class MailComponent  implements EmailService {

  public static final String FACTURA_PDF = "src\\main\\resources\\jasper\\jasperOutput\\Factura";
  @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(
      String to, String subject, String text) {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(to);
      message.setSubject(subject);
      message.setText(text);
      emailSender.send(message);
    }

  @Override
  public ResponseEntity sendMessageWithAttachment(
    String to, String subject, String text, int idFacura){
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = null;
    try {
      helper = new MimeMessageHelper(message, true);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(text);
      FileSystemResource file = new FileSystemResource(new File(FACTURA_PDF + idFacura + ".pdf"));
      helper.addAttachment("factura.pdf", file);
      emailSender.send(message);
      return ResponseEntity.status(200).build();
    } catch (MessagingException e) {
      return ResponseEntity.status(403).build();
    }

  }

}
