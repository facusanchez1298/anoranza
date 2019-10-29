package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity(name = "reservation")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonBackReference
  private User user;
  @NotNull
  @Temporal(TemporalType.DATE)
  private Date ingreso;
  @NotNull
  @Temporal(TemporalType.DATE)
  private Date salida;
  @OneToMany(
    fetch = FetchType.EAGER,
    mappedBy = "habitacion",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
  //@JsonManagedReference
  private List<ReservationHabitacion> habitaciones = new ArrayList<>();

  public Reservation() {
  }

  public Reservation(int id, Date ingreso, Date salida, User user) {
    this.id = id;
    this.user = user;
    this.ingreso = ingreso;
    this.salida = salida;
  }

  public void addhabitations(int habitationId, int quantity){
    habitaciones.add(new ReservationHabitacion(this.id, habitationId, quantity));
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

  public List<ReservationHabitacion> getHabitaciones() {
    return habitaciones;
  }

  public void setHabitaciones(List<ReservationHabitacion> habitaciones) {
    this.habitaciones = habitaciones;
  }
}
