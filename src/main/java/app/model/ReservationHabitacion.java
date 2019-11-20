package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity(name = "reservation_Habitacion")
@Table(name = "revercation_habitacion")
@IdClass(ReservationHabitacionId.class)
public class ReservationHabitacion {
  @Id
  private int idReservation;

  @Id
  private int idHabitacion;

  private int cantidad;

  @ManyToOne
  @JoinColumn(name = "idReservation", referencedColumnName = "id", insertable = false, updatable = false)
  @JsonBackReference
  //@JsonIgnore
  private Reservation reservation;

  @ManyToOne
  @JoinColumn(name = "idHabitacion", referencedColumnName = "id", insertable = false, updatable = false)
  @JsonManagedReference
  //@JsonIgnore
  private Habitacion habitacion;

  public ReservationHabitacion() {
  }

  public ReservationHabitacion(int idReservation, int idHabitacion, int cantidad, Reservation reservation, Habitacion habitacion)
  {
    this.reservation = reservation;
    this.habitacion = habitacion;
    this.idReservation = idReservation;
    this.idHabitacion = idHabitacion;
    this.cantidad = cantidad;
  }

  public int getIdReservation() {
    return idReservation;
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

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }

  public Habitacion getHabitacion() {
    return habitacion;
  }

  public void setHabitacion(Habitacion habitacion) {
    this.habitacion = habitacion;
  }

  public float getPrecio() {
    return this.habitacion.getPrice() * this.cantidad;
  }
}
