package app.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Habitacion{
  @Id
  private int id;
  private int capacidad;
  private String tipo;
  private String description;
  @OneToMany(mappedBy = "habitacion")
  private List<Reservation_Habitacion> reservation;

  public Habitacion() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Reservation_Habitacion> getReservation() {
    return reservation;
  }

  public void setReservation(List<Reservation_Habitacion> reservation) {
    this.reservation = reservation;
  }
}
