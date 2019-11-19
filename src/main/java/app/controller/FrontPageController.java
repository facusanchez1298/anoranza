package app.controller;

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
   * Controlador, genera una factura usando la id de la reservacion que se le pase por el path
   * ej localhost:8080/generatereport/2.
   * @param id
   * @return
   */
  @GetMapping(value = "/generatereport/{id}")
  public String generateReport(@PathVariable String id) {
    Connection conn = null;

    HashMap<String, Object> params = null;

    JasperReport jasperReport = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/anoranza?serverTimezone=UTC", "decodex", "decodex1234");
      params = new HashMap<>();
      int idNumber = Integer.parseInt(id);

      params.put("Idparam", new Integer(idNumber));

      jasperReport = getCompiledFile();
      generateReportPDF(params, jasperReport, conn);

    } catch (SQLException | JRException e) {
      e.printStackTrace();
    } finally {
      try {
        if (conn != null) {
          conn.close();
          conn = null;
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return "historia";


  }

  /**
   * to-do, mover estos metodos a una clase aparte, son utilizados para compilar el jrxml y generar el pdf.
   * @return
   * @throws JRException
   */
  private JasperReport getCompiledFile() throws JRException {

    File reportFile = new File("src\\main\\resources\\jasper\\FinalFactura.jrxml","src\\main\\resources\\jasper\\FinalFactura.jasper");
    if (!reportFile.exists()) {
      JasperCompileManager.compileReportToFile("src\\main\\resources\\jasper\\FinalFactura.jrxml","src\\main\\resources\\jasper\\FinalFactura.jasper");
    }
    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("src\\main\\resources\\jasper\\FinalFactura.jasper");

    return jasperReport;
  }
  private void generateReportPDF (Map parameters, JasperReport jasperReport, Connection conn)throws JRException {
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,conn);
    JasperExportManager.exportReportToPdfFile(jasperPrint,"src\\main\\resources\\jasper\\jasperOutput\\Factura.pdf");
  }


}
