package app.repository;

import app.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
  List<Reservation> findAllByIngresoBetween(Date start, Date end);

  List<Reservation> findAllBySalidaBetween(Date start, Date end);
}
