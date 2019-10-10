package app.controller;
import app.service.implementations.MailServiceImp;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendMailController {

  @Autowired
  private MailServiceImp mailService;

  @GetMapping("/inicioMail")
  public String index(){
    return "send_mail_view";
  }

 /* @PostMapping("/sendMail")
  public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail,
    @RequestParam("subject") String subject, @RequestParam("body") String body) {

    String message = body + "\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
    mailService.sendMail("decodextech@gmail.com", mail, subject, message);

    return "send_mail_view";
  }*/

  @PostMapping("/send")
  public String sendMail() {

    try {
      mailService.enviar();
    } catch (MessagingException e) {
      e.printStackTrace();
    }

    return "send_mail_view";
  }
}