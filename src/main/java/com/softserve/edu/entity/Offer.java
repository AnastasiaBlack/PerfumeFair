package com.softserve.edu.entity;

import javax.persistence.*;

@Entity
@Table(name="offers")
public class Offer {
    @Id @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private int id;
    @Column(name="price_per_ml")
    private int pricePerMl;
    @Column(name="volume_ml")
    private int volumeForSale;
    @OneToOne(optional=true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perfume", nullable = true)
    private Perfume perfume;

    transient private String brandName;

    public void setPricePerMl(int pricePerMl) {
        this.pricePerMl = pricePerMl;
    }

    public void setVolumeForSale(int volumeForSale) {
        this.volumeForSale = volumeForSale;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPricePerMl() {
        return pricePerMl;
    }

    public void setPricePerMl(String stringPricePerMl) {
        if(!stringPricePerMl.matches("\\d*")){
            throw new IllegalArgumentException("Sorry, you've entered the wrong" +
                    "value for price. Use whole numbers only.");
        }
        int pricePerMl = Integer.parseInt(stringPricePerMl);
        this.pricePerMl = pricePerMl;
    }

    public int getVolumeForSale() {
        return volumeForSale;
    }

    public void setVolumeForSale(String stringVolumeForSale) {
        if(!stringVolumeForSale.matches("\\d*")){
            throw new IllegalArgumentException("Sorry, you've entered the wrong" +
                    "value for volume to be sold. Use whole numbers only.");
        }
        int volumeForSale = Integer.parseInt(stringVolumeForSale);
        this.volumeForSale = volumeForSale;
    }


    public Perfume getPerfume() {
        return perfume;
    }

    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }
}
