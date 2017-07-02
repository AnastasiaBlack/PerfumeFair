package com.softserve.edu.entity;

import javax.persistence.*;

@Entity
@Table(name= "Perfumes")
public class Perfume {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false, unique = true)
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

 }
