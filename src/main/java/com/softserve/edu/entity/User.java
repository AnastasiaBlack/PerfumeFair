package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade =
            CascadeType.REFRESH)
    private List<SubmittedOrder> userOrdersList = new ArrayList<>();

    public User() {
    }


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}


