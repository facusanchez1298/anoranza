package app;

import app.model.Reservation;
import app.service.InvoiceService;
import app.service.interfaces.ReservationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sun.awt.OSInfo;

@SpringBootApplication
@ComponentScan
public class Application {





    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);











    }
}
