package com.softserve.edu.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;
    @Column(name = "volume_ordered_ml")
    private int volumeOrdered;
    @OneToOne(optional = true)
    private Offer offer;

    @ManyToOne(optional = true, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_cart", nullable = true)
    private Cart cart;


    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_submittedOrder", nullable = true)
    private SubmittedOrder submittedOrders;

    public SubmittedOrder getSubmittedOrders() {
        return submittedOrders;
    }

    public void setSubmittedOrders(SubmittedOrder submittedOrders) {
        this.submittedOrders = submittedOrders;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(7,
                77). // two randomly chosen prime numbers
                append(id).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Sale))
            return false;
        if (obj == this)
            return true;

        Sale sale = (Sale) obj;
        return new EqualsBuilder().
                append(id, sale.id).
                isEquals();
    }

    private int singleSalePrice;

    public int getSingleSalePrice() {
        return (volumeOrdered*offer.getPricePerMl());
    }

    public void setSingleSalePrice(int singleSalePrice) {
        this.singleSalePrice = singleSalePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolumeOrdered() {
        return volumeOrdered;
    }

    public void setVolumeOrdered(int volumeOrdered) {
        this.volumeOrdered = volumeOrdered;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
