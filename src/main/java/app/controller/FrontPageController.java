package app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FrontPageController {
  /**
   * muestra la pagina de inicio
   * @return el html de la pagina de inicio
   */
  @GetMapping("/inicio")
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
}
