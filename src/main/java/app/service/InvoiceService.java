package app.service;

import com.sun.mail.iap.ByteArray;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

@Service
public class InvoiceService {



    private final String invoice_template_path = "/FacturaFinalFinal.jrxml";





    public byte[] generateInvoiceFor (int id) throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        ClassLoader classLoader = getClass().getClassLoader();
        JasperReport jasperReport = JasperCompileManager.compileReport(classLoader.getResourceAsStream("FacturaFinalFinal.jrxml"));
        String host = "jdbc:mysql://db4free.net:3306/anoranza?serverTimezone=UTC";
        String uname = "decodex";
        String password = "decodex1234";
        Connection conn = DriverManager.getConnection(host,uname,password);
        //Map<String,Object> param = parameters(id);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
        HtmlExporter exporter = new HtmlExporter();
        ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
        exporter.setExporterInput(exporterInput);
        HtmlExporterOutput exporterOutput = new SimpleHtmlExporterOutput(out);
        exporter.setExporterOutput(exporterOutput);
        SimpleHtmlExporterConfiguration configuration = new SimpleHtmlExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        System.out.print("Should work?");

        return out.toByteArray();

    }
    //Carga la factura desde el template (el JRXML)
    private JasperReport loadTemplate() throws JRException {
        final InputStream reportInputStream = getClass().getResourceAsStream(invoice_template_path);
        final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

        return JasperCompileManager.compileReport(jasperDesign);
    }

    private Map<String,Object> parameters(int id){
        final Map<String,Object> parameters = new HashMap<>();


        parameters.put("idparam", id);

        return parameters;
    }




}
