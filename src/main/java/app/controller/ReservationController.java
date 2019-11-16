package app.controller;

import app.model.para_metodos.EnterDataIsFree;
import app.model.para_metodos.EnterDataReservation;
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
 private ReservationService reservationService;

  public ReservationController(ReservationServiceImp reservationRepository) {
    this.reservationService = reservationRepository;
  }

  @PostMapping("/addReservation")
  public ResponseEntity addReservation(@RequestBody EnterDataReservation reservation){
    return reservationService.addReservation(reservation.getReservation(),
      reservation.getIdHabitacion(), reservation.getQuantity(), reservation.getUserId());
  }

  @GetMapping("/allReservations")
  public List<Reservation> getAllReservations(){
    return reservationService.getAll();
  }

   @GetMapping("/isFree")
  public boolean isFree( @RequestBody EnterDataIsFree dataIsFree){
    return reservationService
      .isFree(dataIsFree.getId_habitacion(),dataIsFree.getIngreso(),dataIsFree.getSalida());
  }
}
