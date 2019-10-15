package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "reservation")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonBackReference
  @NotNull
  private User user;
  @NotNull
  private Date ingreso;
  @NotNull
  private Date salida;
  @NotNull
  private int personas;
  @NotNull
  private int habitaciones;

  public Reservation() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getIngreso() {
    return ingreso;
  }

  public void setIngreso(Date ingreso) {
    this.ingreso = ingreso;
  }

  public Date getSalida() {
    return salida;
  }

  public void setSalida(Date salida) {
    this.salida = salida;
  }

  public int getPersonas() {
    return personas;
  }

  public void setPersonas(int personas) {
    this.personas = personas;
  }

  public int getHabitaciones() {
    return habitaciones;
  }

  public void setHabitaciones(int habitaciones) {
    this.habitaciones = habitaciones;
  }
}
