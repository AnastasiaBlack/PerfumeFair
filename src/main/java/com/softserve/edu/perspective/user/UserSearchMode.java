package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.Offer;
import com.softserve.edu.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSearchMode {
    private final OfferService offerService;
    private List<Offer> currentOffersList;

    @Autowired
    public UserSearchMode(OfferService offerService) {
        this.offerService = offerService;
    }

    public List<Offer> showOffersByPerfume(String perfumeName) {
        currentOffersList = offerService.getAllOffersByPerfumeFilter
                (perfumeName);
        return currentOffersList;
    }

    public List<Offer> showOffersByBrand(String brandName) {
        currentOffersList = offerService.getAllOffersByBrandFilter(brandName);
        return currentOffersList;
    }




}
