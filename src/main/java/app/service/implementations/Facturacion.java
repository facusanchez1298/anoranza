package app.service.implementations;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class Facturacion {
  /**
   * Controlador, genera una factura usando la id de la reservacion que se le pase por el path
   * ej localhost:8080/generatereport/2.
   * @param id
   * @return
   */
  public String generateReport(String id) {
    Connection conn = null;
    HashMap<String, Object> params = null;
    JasperReport jasperReport = null;
    try {
      conn = DriverManager
        .getConnection("jdbc:mysql://db4free.net:3306/anoranza?serverTimezone=UTC", "decodex", "decodex1234");
      params = new HashMap<>();
      int idNumber = Integer.parseInt(id);
      params.put("Idparam", new Integer(idNumber));
      jasperReport = getCompiledFile();
      generateReportPDF(params, jasperReport, conn, id);

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

  private void generateReportPDF (Map parameters, JasperReport jasperReport, Connection conn, String id)throws JRException {
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,conn);
    JasperExportManager
      .exportReportToPdfFile(jasperPrint,"src\\main\\resources\\jasper\\jasperOutput\\Factura" + id + ".pdf");
  }
}
