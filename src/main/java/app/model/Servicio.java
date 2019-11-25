package app.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity(name = "servicio")
public class Servicio {
  @Id
  @Column(updatable = false, nullable = false)
  private int id;
  private float precio;
  private String medios_pago;
  @OneToMany(
    mappedBy = "servicio",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
  //@JsonManagedReference
  private List<UserServicio> usuarios = new ArrayList<>();

  public Servicio() {
  }

  public Servicio(int tipo, float precio, String medios_pago) {
    this.id = tipo;
    this.precio = precio;
    this.medios_pago = medios_pago;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public float getPrecio() {
    return precio;
  }

  public void setPrecio(float precio) {
    this.precio = precio;
  }

  public String getMedios_pago() {
    return medios_pago;
  }

  public void setMedios_pago(String medios_pago) {
    this.medios_pago = medios_pago;
  }

  public List<UserServicio> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<UserServicio> usuarios) {
    this.usuarios = usuarios;
  }
}
