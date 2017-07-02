package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    private int id;
    private User user;
    private List<Sale> sales = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart", cascade =
            CascadeType.ALL)
    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable =
            false)
    public int getId() {
        return id;
    }

    public void addSaleToCart(Sale sale) {
        sales.add(sale);
    }

    public void removeSale(Sale sale) {
        sales.remove(sale);
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
