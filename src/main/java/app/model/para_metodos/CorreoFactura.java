package app.model.para_metodos;

public class CorreoFactura {
  private String correo;
  private int idFactura;

  public CorreoFactura(String correo, int idFactura) {
    this.correo = correo;
    this.idFactura = idFactura;
  }

  public CorreoFactura() {
  }

  public int getIdFactura() {
    return idFactura;
  }

  public void setIdFactura(int idFactura) {
    this.idFactura = idFactura;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }
}
