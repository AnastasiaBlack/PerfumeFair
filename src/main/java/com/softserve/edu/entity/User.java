package com.softserve.edu.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;
    @Column(name="nickname")
    private String nickname;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
