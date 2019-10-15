package app.controller;

import app.model.Reservation;
import app.service.implementations.ReservationServiceImp;
import app.service.interfaces.ReservationService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
 private ReservationService reservationRepository;

  public ReservationController(ReservationServiceImp reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @PostMapping("/addReservation")
  public ResponseEntity addReservation(@RequestBody Reservation reservation){
    return reservationRepository.addReservation(reservation);
  }

  @GetMapping("/allReservations")
  public List<Reservation> getAllReservations(){
    return reservationRepository.getAll();
  }
}
