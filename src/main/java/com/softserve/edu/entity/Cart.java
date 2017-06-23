package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;

    @OneToOne
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade =
            CascadeType.ALL)
    private List<Sale> sales= new ArrayList<>();

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void addSaleToCart(Sale sale){
        sales.add(sale);
    }
    public void removeSale(Sale sale){
        sales.remove(sale);
    }
    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
