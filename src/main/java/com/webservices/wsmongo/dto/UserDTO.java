package com.webservices.wsmongo.dto;

import java.io.Serializable;

import com.webservices.wsmongo.domain.User;

//Função do DTO: apenas seletas informações que deseja são passadas de uma determinada classe
// ex: user pode passar apenas id, name, se tivesse informações sensíveis não precisaria carregar junto
public class UserDTO implements Serializable {
  private String id;
  private String name;
  private String email;

  public UserDTO() {

  }

  public UserDTO(User obj) {
    id = obj.getId();
    name = obj.getName();
    email = obj.getEmail();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
