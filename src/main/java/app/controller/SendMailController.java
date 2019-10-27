package app.controller;
import app.service.implementations.MailComponent;
import app.service.implementations.MailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendMailController {

  @Autowired
  private MailServiceImp mailService;

@Autowired
private MailComponent mailComponent;

 @PostMapping("/sendMail")
  public String sendMail(@RequestParam("name") String name, @RequestParam("tel") String cel,@RequestParam("mail") String mail,
    @RequestParam("consulta") String body) {

      mailService.sendMail("decodextech@gmail.com", mail, "decodex", "gracias por comunicarte con nosotros, en breve un asesor se comunicara con usted. \n \t\t atte. DECODEX");
    String message = body + "nombre = " + name + "\n telefono = " + cel + "\n mail " + mail;
    mailService.sendMail("decodextech@gmail.com", "decodextech@gmail.com" , "comunicado", message);

    return "/consulta";
  }
}