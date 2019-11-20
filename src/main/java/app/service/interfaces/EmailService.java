package app.service.interfaces;


import org.springframework.http.ResponseEntity;

public interface EmailService {

  void sendSimpleMessage(
    String to, String subject, String text);

  ResponseEntity sendMessageWithAttachment(
    String to, String subject, String text, int idFactura);
}
