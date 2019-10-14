package app.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne
  private User user;
  private Date ingreso;
  private Date salida;
  private int personas;
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
