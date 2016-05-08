package com.tshop.entity;

import java.io.Serializable;
/**
 * @author Han, Tixiang 2016年5月7日
 *
 */
public class User implements Serializable {

  private static final long serialVersionUID = 8751282105532159742L;

  private long userId;
  private String username;
  private String password;
  private String nickname;
  private String status;
  private String country;
  private String state;
  private String city;
   private String zip;
  private String address;
  private String phone;
  private String email;
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getUserId() {
    return userId;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
