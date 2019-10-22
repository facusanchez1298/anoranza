package app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
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
  @OneToMany(
    mappedBy = "habitacion",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
  @JsonManagedReference
  private List<reservationHabitacion> reservation;

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

  public List<reservationHabitacion> getReservation() {
    return reservation;
  }

  public void setReservation(List<reservationHabitacion> reservation) {
    this.reservation = reservation;
  }
}
