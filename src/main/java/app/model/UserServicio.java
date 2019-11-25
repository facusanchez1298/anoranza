package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity(name = "usuario_servicio")
@Table(name = "usuario_servicio")
@IdClass(UserServicioId.class)
public class UserServicio {

  @Id
  private int idUser;

  @Id
  private int idServicio;

  private int quantity;

  private Time hora;

  private Date fecha;

  @ManyToOne
  @JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
  @JsonIgnore
  private User usuario;

  @ManyToOne
  @JoinColumn(name = "idServicio", referencedColumnName = "id", insertable = false, updatable = false)
  @JsonIgnore
  private Servicio servicio;


  public UserServicio() {
  }

  public UserServicio(int idUser, int idServicio, int quantity, Time hora, Date fecha,
    User usuario, Servicio servicio) {
    this.idUser = idUser;
    this.idServicio = idServicio;
    this.quantity = quantity;
    this.hora = hora;
    this.fecha = fecha;
    this.usuario = usuario;
    this.servicio = servicio;
  }

  public int getQuantity() {

    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public int getIdServicio() {
    return idServicio;
  }

  public void setIdServicio(int idServicio) {
    this.idServicio = idServicio;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public int getTipoServicio() {
    return idServicio;
  }

  public void setTipoServicio(int tipoServicio) {
    this.idServicio = tipoServicio;
  }

  public Time getHora() {
    return hora;
  }

  public void setHora(Time hora) {
    this.hora = hora;
  }

  public User getUsuario() {
    return usuario;
  }

  public void setUsuario(User usuario) {
    this.usuario = usuario;
  }

  public Servicio getServicio() {
    return servicio;
  }

  public void setServicio(Servicio servicio) {
    this.servicio = servicio;
  }
}
