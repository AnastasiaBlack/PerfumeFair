package com.softserve.edu.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Users")
public class User implements UserDetails {
    @Id @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;
    @Column(name="nickname")
    private String nickname;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;


    private String password;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")})
    private Role role;




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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> results = new ArrayList<>();
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
