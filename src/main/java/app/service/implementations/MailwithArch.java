package app.service.implementations;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Daniel Mendoza Caro
 */
public class MailwithArch {

  public static final String ruta = "src/main/resources/prueba.pdf";
  private static final String usuarioCorreo = "decodextech@gmail.com";
  private static final String password = "decodex1234";

  private String nombreArchivo;

  private String destinatario;
  private String asunto;
  private String mensaje;


  public MailwithArch(String nombreArchivo,
    String destinatario, String asunto, String mensaje) {
    this.nombreArchivo = nombreArchivo;
    this.destinatario = destinatario;
    this.asunto = asunto;
    this.mensaje = mensaje;
  }

  public boolean sendEmail() {
    try {
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.setProperty("mail.smtp.starttls.enable", "true");
      props.setProperty("mail.smtp.port", "587");
      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      props.setProperty("mail.smtp.user", usuarioCorreo);
      props.setProperty("mail.smtp.auth", "true");

      Session session = Session.getDefaultInstance(props, null);
      BodyPart texto = new MimeBodyPart();
      texto.setText(mensaje);

      BodyPart adjunto = new MimeBodyPart();
      if (!ruta.equals("")) {
        adjunto.setDataHandler(
          new DataHandler(new FileDataSource(ruta)));
        adjunto.setFileName(nombreArchivo);
      }

      MimeMultipart multiParte = new MimeMultipart();
      multiParte.addBodyPart(texto);
      if (!ruta.equals("")) {
        multiParte.addBodyPart(adjunto);
      }

      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(usuarioCorreo));
      message.addRecipient(
        Message.RecipientType.TO,
        new InternetAddress(destinatario));
      message.setSubject(asunto);
      message.setContent(multiParte);

      Transport t = session.getTransport("smtp");
      t.connect(usuarioCorreo, password);
      t.sendMessage(message, message.getAllRecipients());
      t.close();

      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
  }

  public boolean sendEmail(FileDataSource archivo) {
    try {
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.setProperty("mail.smtp.starttls.enable", "true");
      props.setProperty("mail.smtp.port", "587");
      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      props.setProperty("mail.smtp.user", usuarioCorreo);
      props.setProperty("mail.smtp.auth", "true");

      Session session = Session.getDefaultInstance(props, null);
      BodyPart texto = new MimeBodyPart();
      texto.setText(mensaje);

      BodyPart adjunto = new MimeBodyPart();
      adjunto.setDataHandler(new DataHandler(archivo));
      adjunto.setFileName(nombreArchivo);

      MimeMultipart multiParte = new MimeMultipart();
      multiParte.addBodyPart(texto);
      multiParte.addBodyPart(adjunto);

      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(usuarioCorreo));
      message.addRecipient(
        Message.RecipientType.TO,
        new InternetAddress(destinatario));
      message.setSubject(asunto);
      message.setContent(multiParte);

      Transport t = session.getTransport("smtp");
      t.connect(usuarioCorreo, password);
      t.sendMessage(message, message.getAllRecipients());
      t.close();

      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
  }
}

