package app.model;

public class EnterDataReservation {
  private Reservation reservation;
  private int idHabitacion;
  private int quantity;
  private int userId;

  public EnterDataReservation() {
  }

  public EnterDataReservation(Reservation reservation, int idHabitacion, int quantity, int userId) {
    this.reservation = reservation;
    this.idHabitacion = idHabitacion;
    this.quantity = quantity;
    this.userId = userId;
  }

  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }

  public int getIdHabitacion() {
    return idHabitacion;
  }

  public void setIdHabitacion(int idHabitacion) {
    this.idHabitacion = idHabitacion;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
