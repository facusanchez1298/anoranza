package app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user", updatable = false, nullable = false)
  private int id;
  @Column(name = "user_Name", unique = true)
  @NotBlank
  private String userName;
  @Column(name = "password")
  @NotBlank
  private String password;
  @Column(name = "name")
  @NotBlank
  private String name;
  @Column(name = "sur_name")
  @NotBlank
  private String surName;
  @Column(name = "direccion")
  private String direccion;
  @Column(name = "telefono")
  @NotNull
  private Integer telefono;
  @Column(name = "address")
  @NotBlank
  private String address;
  @OneToMany(
    mappedBy = "user",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  @JsonManagedReference
  private List<Reservation> reservation;

  public User(){

  }

  public User(
    @NotBlank String userName,
    @NotBlank String password,
    @NotBlank String name,
    @NotBlank String direccion,
    @NotBlank String surName,
    @NotNull Integer telefono,
    @NotBlank String address) {
    this.userName = userName;
    this.password = password;
    this.name = name;
    this.direccion = direccion;
    this.surName = surName;
    this.telefono = telefono;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public Integer getTelefono() {
    return telefono;
  }

  public void setTelefono(Integer telefono) {
    this.telefono = telefono;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Reservation> getReservation() {
    return reservation;
  }

  public void setReservation(List<Reservation> reservation) {
    this.reservation = reservation;
  }
}


