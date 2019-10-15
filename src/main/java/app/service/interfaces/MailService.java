package app.service.interfaces;

public interface MailService {
  public void sendMail(String from, String to, String subject, String body);
}
