package app.service.interfaces;

import app.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ReservationService {

  ResponseEntity addReservation(Reservation reservation, int idHabitacion, int quantity, int userId);

  List<Reservation> getAll();

  public boolean isFree(int id_habitacion, Date ingreso, Date salida);

  Reservation getById(int id);
}
