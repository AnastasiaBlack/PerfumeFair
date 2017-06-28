package com.softserve.edu.dao;

import com.softserve.edu.entity.Offer;

import java.util.List;

public interface OfferDAO extends ElementDAO<Offer> {
    List<Offer> getAllOffersByPerfumeFilter(String perfumeName);
    List<Offer> getAllOffersByBrandFilter(String brandName);
}
