package app.controller;

import app.model.Reservation;
import app.service.InvoiceService;
import app.service.interfaces.ReservationService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.Text;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class FrontPageController {
  /**
   * muestra la pagina de inicio
   * @return el html de la pagina de inicio
   */
  InvoiceService invoiceService;

  @GetMapping("/")
  public String index() {
    return "inicio";
  }
  /**
   * muestra la pagina de reserva
   * @return el html de la pagina de reserva
   */
  @GetMapping("/reserva")
  public String getReservas(){
    return "reserva";
  }
  /**
   * muestra la pagina de actividades
   * @return el html de la pagina de actividades
   */
  @GetMapping("/actividades")
  public String getActividades(){
    return "actividades";
  }
  /**
   * muestra la pagina de instalaciones
   * @return el html de la pagina de instalaciones
   */
  @GetMapping("/instalaciones")
  public String getInstalaciones(){
    return "instalaciones";
  }
  /**
   * muestra la pagina de contacto
   * @return el html de la pagina de contacto
   */
  @GetMapping("/contacto")
  public String getContacto(){
    return "contacto";
  }

  @GetMapping(value = "/factura" , produces = MediaType.TEXT_HTML_VALUE)
  public @ResponseBody byte[] getFactura() throws Exception {

    byte[] factura = invoiceService.generateInvoiceFor(1);
    return factura;
  }




}
