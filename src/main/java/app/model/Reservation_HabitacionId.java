package app.model;

import java.io.Serializable;
import javax.persistence.Column;


public class Reservation_HabitacionId implements Serializable {
  private static final long serialVersionUID = 5787285946857659475L;
  @Column(name = "idReservation")
  private Long idReservation;

  @Column(name = "idHabitacion")
  private Long idHabitacion;

  public Reservation_HabitacionId() {
  }

  public Reservation_HabitacionId(Long idReservation, Long idHabitacion) {
    this.idReservation = idReservation;
    this.idHabitacion = idHabitacion;
  }

  public Long getIdReservation() {
    return idReservation;
  }

  public void setIdReservation(Long idReservation) {
    this.idReservation = idReservation;
  }

  public Long getIdHabitacion() {
    return idHabitacion;
  }

  public void setIdHabitacion(Long idHabitacion) {
    this.idHabitacion = idHabitacion;
  }
}
