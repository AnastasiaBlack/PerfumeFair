package com.softserve.edu.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade =
            CascadeType.REFRESH)
    private List<SubmittedOrder> userOrdersList = new ArrayList<>();


    public void addOrder(SubmittedOrder submittedOrder){
        userOrdersList.add(submittedOrder);
    }
    public void removeOrder(SubmittedOrder submittedOrder){
        userOrdersList.remove(submittedOrder);
    }


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

    public List<SubmittedOrder> getUserOrdersList() {
        return userOrdersList;
    }

    public void setUserOrdersList(List<SubmittedOrder> userOrdersList) {
        this.userOrdersList = userOrdersList;
    }
}
