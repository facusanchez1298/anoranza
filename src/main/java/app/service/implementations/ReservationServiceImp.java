package app.service.implementations;

import app.model.Habitacion;
import app.model.Reservation;
import app.repository.ReservationRepository;
import app.service.interfaces.ReservationService;
import java.util.Date;
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
  public ResponseEntity addReservation(Reservation reservation, int idHabitacion, int quantity) {
    reservation.addhabitations(idHabitacion, quantity);
    reservationRepository.save(reservation);
    return ResponseEntity.status(200).build();
  }

  @Override
  public List<Reservation> getAll() {
    return reservationRepository.findAll();
  }

  @Override
  public boolean isFree(int id_habitacion, Date ingreso, Date salida){
    List<Reservation> ingresos = reservationRepository.findAllByIngresoBetween(ingreso, salida);
    List<Reservation> salidas = reservationRepository.findAllBySalidaBetween(ingreso, salida);
    boolean free = false;
    free = isFree(ingresos, id_habitacion);
    free = isFree(salidas, id_habitacion);
    return free;
  }

  @Override
  public Reservation getById(int id) {

    return reservationRepository.getOne(id);

  }

  private boolean isFree(List<Reservation> lista, int id_habitacion){
   /* for (int i = 0; i <lista.size(); i++) {
      List<Habitacion> habitaciones = lista.get(i).getHabitaciones();
      for (Habitacion habitacion: habitaciones) {
        if(habitacion.getId() == id_habitacion) return true;
      }
    }*/ //todo arreglar este metodo
    return true;
  }

}
