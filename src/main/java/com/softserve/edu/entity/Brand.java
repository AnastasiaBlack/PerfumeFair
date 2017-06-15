package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Perfume> perfumes;


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

    public List<Perfume> getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(List<Perfume> perfumes) {
        this.perfumes = perfumes;
    }
}
