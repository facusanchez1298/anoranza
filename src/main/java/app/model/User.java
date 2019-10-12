package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
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
  @Column(name = "last_Name")
  private String lastName;
  @Column(name = "sur_name")
  @NotBlank
  private String surName;
  @Column(name = "age")
  @NotNull
  private Integer age;
  @Column(name = "address")
  @NotBlank
  private String address;

  public User(){

  }

  public User(int id, @NotBlank String userName,
    @NotBlank String password,
    @NotBlank String name, String lastName,
    @NotBlank String surName, @NotNull Integer age,
    @NotBlank String address) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.name = name;
    this.lastName = lastName;
    this.surName = surName;
    this.age = age;
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

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}


