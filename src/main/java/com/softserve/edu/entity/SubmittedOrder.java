package com.softserve.edu.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "submittedorders")
public class SubmittedOrder {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;

    @Column(name="total_price")
    private int totalPrice;

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "submittedOrders", cascade =
            CascadeType.ALL)
    private List<Sale> sales;

    public void addSaleToOrder(Sale sale){
        sales.add(sale);
    }
    public void removeSaleFromOrder(Sale sale){
        sales.remove(sale);
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void submitSaleToOrder(Sale sale){
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}

