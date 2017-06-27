package com.softserve.edu.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    private String role;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")})
    private Set<User> userRoles;



}
