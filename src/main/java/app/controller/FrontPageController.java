package app.controller;

import app.service.implementations.Facturacion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FrontPageController {
  /**
   * muestra la pagina de inicio
   * @return el html de la pagina de inicio
   */


  @GetMapping("/login")
  public String login() { return "login"; }



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

  /**
   * muestra la pagina de registro
   * @return el html de la pagina de contacto
   */
  @GetMapping("/registro")
  public String getRegistro(){
    return "registro";
  }

  /**
   * Controlador, genera una factura usando la id de la reservacion que se le pase por el path
   * ej localhost:8080/generatereport/2.
   * @param id
   * @return
   */
  @GetMapping(value = "/generatereport/{id}")
  public String generateReport(@PathVariable String id) {
    Facturacion facturacion = new Facturacion();
    facturacion.generateReport(id);
    return "inicio";
  }




}
