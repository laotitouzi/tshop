package com.tshop.entity;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author Han, Tixiang 2016年5月7日
 */
public class User implements UserDetails {

    private static final long serialVersionUID = 8751282105532159742L;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    private long userId;
    @NotEmpty(message = "用户名不能为空")
    @Length(max = 30,message = "用户名不能超过30字符")
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


    private List<GrantedAuthority> authorities;


    public User() {
        this.accountNonExpired= true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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


    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}

