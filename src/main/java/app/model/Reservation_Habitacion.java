package app.model;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity(name = "reservation_Habitacion")
@Table(name = "revercation_habitacion")
@IdClass(Reservation_HabitacionId.class)
public class Reservation_Habitacion {
  @Id
  private Long idReservation;

  @Id
  private Long idHabitacion;

  private int cantidad;

  @ManyToOne
  @JoinColumn(name = "idReservation", referencedColumnName = "id", insertable = false, updatable = false)
  private Reservation reservation;

  @ManyToOne
  @JoinColumn(name = "idHabitacion", referencedColumnName = "id", insertable = false, updatable = false)
  private Habitacion habitacion;

  public Reservation_Habitacion() {
  }

  public Reservation_Habitacion(Long idReservation, Long idHabitacion, int cantidad)
  {
    this.idReservation = idReservation;
    this.idHabitacion = idHabitacion;
    this.cantidad = cantidad;
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
}
