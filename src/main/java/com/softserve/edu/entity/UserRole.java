package com.softserve.edu.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class UserRole {

    @ManyToMany(mappedBy="userRoles")
    private Set<User> user = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private ListRole listRole;

    public UserRole(){}

    public UserRole(int id){

    }

}
