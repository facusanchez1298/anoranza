package app.service.interfaces;

import app.model.Reservation;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ReservationService {
  ResponseEntity addReservation(Reservation reservation);

  List<Reservation> getAll();
}
