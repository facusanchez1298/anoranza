package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Column;


public class ReservationHabitacionId implements Serializable {

  private static final long serialVersionUID = 5787285946857659475L;
  @Column(name = "idReservation")

  private int idReservation;

  @Column(name = "idHabitacion")

  private int idHabitacion;

  public ReservationHabitacionId() {
  }

  public ReservationHabitacionId(int idReservation, int idHabitacion) {
    this.idReservation = idReservation;
    this.idHabitacion = idHabitacion;
  }

  public void setIdReservation(int idReservation) {
    this.idReservation = idReservation;
  }

  public int getIdHabitacion() {
    return idHabitacion;
  }

  public void setIdHabitacion(int idHabitacion) {
    this.idHabitacion = idHabitacion;
  }
}