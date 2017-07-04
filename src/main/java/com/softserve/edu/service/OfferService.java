package com.softserve.edu.service;

import com.softserve.edu.entity.Offer;

import java.util.List;

public interface OfferService {
    void addOffer(Offer offer);

    void updateOffer(Offer offer);

    Offer getOfferById(int id);

    void deleteOffer(Offer offer);

    List<Offer> getAllOffers();

    List<Offer> getAllOffersByPerfumeFilter(String perfumeName);

    List<Offer> getAllOffersByBrandFilter(String brandName);

    List<Offer> getAllOffersByBrandAndPriceFilter(String brandName, int price);
}
