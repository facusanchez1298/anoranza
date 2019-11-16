package app.service.implementations;

import app.model.Habitacion;
import app.model.Reservation;
import app.model.ReservationHabitacion;
import app.model.User;
import app.repository.HabitacionRepository;
import app.repository.ReservationRepository;
import app.service.interfaces.ReservationService;
import app.service.interfaces.UserServices;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImp implements ReservationService {

  private ReservationRepository reservationRepository;
  private UserServices userServices;
  private HabitacionRepository habitacionRepository;

  public ReservationServiceImp(ReservationRepository reservationRepository,
    UserServices userServices, HabitacionRepository habitacionRepository) {
    this.reservationRepository = reservationRepository;
    this.userServices = userServices;
    this.habitacionRepository = habitacionRepository;
  }

  @Override
  public ResponseEntity addReservation(Reservation reservation, int idHabitacion, int quantity,
    int userId) {
    if(!isFree(idHabitacion, reservation.getIngreso(),reservation.getSalida()))
      throw new RuntimeException("no esta libre la habitacion en esta fecha");
    User user = userServices.findById(userId);
    Habitacion habitacion = habitacionRepository.findById(idHabitacion).get();
    reservation.setUser(user);
    reservation = reservationRepository.save(reservation);
    reservation.addhabitations(idHabitacion, quantity, habitacion );
    reservation.addPrice(reservation.getHabitaciones());
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
    boolean freeIngreso = false, freeSalida  = false;
    freeIngreso = isFree(ingresos, id_habitacion);
    freeSalida = isFree(salidas, id_habitacion);
    if (!freeIngreso || !freeSalida) return false;
    return true;
  }

  /**
   * recorremos todas las reservaciones a ver si aparece la habitacion que queremos,
   * si aparece es por que no esta libre
   * @param lista
   * @param id_habitacion
   * @return
   */
  private boolean isFree(List<Reservation> lista, int id_habitacion){
   for (int i = 0; i <lista.size(); i++) {
     List<ReservationHabitacion> habitaciones = lista.get(i).getHabitaciones();
     for (int j = 0; j < habitaciones.size(); j++) {
       if(habitaciones.get(j).getIdHabitacion() == id_habitacion){
         return false;
       }
     }
   }
   return true;
  }

}
