package app.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Habitacion {
  @Id
  private int id;
  private int capacidad;
  private String tipo;
  private String description;
  @ManyToMany(mappedBy = "habitaciones")
  private List<Reservation> reservation;

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

  public List<Reservation> getReservation() {
    return reservation;
  }

  public void setReservation(List<Reservation> reservation) {
    this.reservation = reservation;
  }
}
