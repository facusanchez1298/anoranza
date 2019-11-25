package app.model;

import java.io.Serializable;
import javax.persistence.Column;

public class UserServicioId implements Serializable {
  private static final long serialVersionUID = -7485355315499188298L;
  @Column(name = "idUser")
  private int idUser;
  @Column(name = "idServicio")
  private int idServicio;

  public UserServicioId() {
  }

  public UserServicioId(int usuario, int servicio) {
    this.idUser = usuario;
    this.idServicio = servicio;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public int getIdServicio() {
    return idServicio;
  }

  public void setIdServicio(int idServicio) {
    this.idServicio = idServicio;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }
}
