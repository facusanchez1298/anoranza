package app.model.para_metodos;

import java.util.Date;

public class EnterDataIsFree {
  private int id_habitacion;
  private Date ingreso;
  private java.util.Date salida;

  public EnterDataIsFree() {
  }

  public EnterDataIsFree(int id_habitacion, Date ingreso, Date salida) {
    this.id_habitacion = id_habitacion;
    this.ingreso = ingreso;
    this.salida = salida;
  }

  public int getId_habitacion() {
    return id_habitacion;
  }

  public void setId_habitacion(int id_habitacion) {
    this.id_habitacion = id_habitacion;
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
}
