package app.controller;
import app.model.para_metodos.CorreoFactura;
import app.service.implementations.Facturacion;
import app.service.implementations.MailServiceImp;
import app.service.interfaces.EmailService;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SendMailController {

  public static final String FACTURA = "src\\main\\resources\\jasper\\jasperOutput\\Factura";
  @Autowired
  private MailServiceImp mailService;

  @Autowired
  private EmailService emailService;

  @PostMapping("/sendMail")
  public String sendMail(@RequestBody String name, @RequestBody String cel,@RequestBody String mail,
    @RequestBody String body) {
      mailService.sendMail("decodextech@gmail.com", mail, "decodex", "gracias por comunicarte con nosotros, en breve un asesor se comunicara con usted. \n \t\t atte. DECODEX");
    String message = body + "nombre = " + name + "\n telefono = " + cel + "\n mail " + mail;
    mailService.sendMail("decodextech@gmail.com", "decodextech@gmail.com" , "comunicado", message);
    return "/consulta";
  }

  @PostMapping("/sendFactura")
  public ResponseEntity mailWithPDF(@RequestBody CorreoFactura mail) {
    File file = new File(FACTURA + mail.getIdFactura() + ".pdf");
    if (!file.exists()){
      Facturacion facturacion = new Facturacion();
      facturacion.generateReport(String.valueOf(mail.getIdFactura()));
    }
    return emailService.sendMessageWithAttachment(mail.getCorreo(), "Factura Añoranza Chaqueña", "recuerde que tiene 5 dias antes de su reservacion para pagar o la recervacion se dara de baja", mail.getIdFactura());
  }
  //todo toda la logica la tenemos que mover a un servicio pero tengo sueño



}