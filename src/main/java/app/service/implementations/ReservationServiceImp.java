package app.service.implementations;

import app.model.Reservation;
import app.repository.ReservationRepository;
import app.service.interfaces.ReservationService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImp implements ReservationService {

  private ReservationRepository reservationRepository;

  public ReservationServiceImp(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public ResponseEntity addReservation(Reservation reservation) {
    reservationRepository.save(reservation);
    return ResponseEntity.status(200).build();
  }

  @Override
  public List<Reservation> getAll() {
    return reservationRepository.findAll();
  }

  public boolean isFree(int id_habitacion){
    //reservationRepository. todo armar esta funcion
    return true;
  }
}
