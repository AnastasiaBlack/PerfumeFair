package com.softserve.edu.service.impl;

import com.softserve.edu.dao.OfferDAO;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferDAO offerDAO;

    @Autowired
    public void setOfferDAO(OfferDAO offerDAO) {
        this.offerDAO = offerDAO;
    }

    @Override
    @Transactional
    public void addOffer(Offer offer) {
        offerDAO.addElement(offer);
    }

    @Override
    @Transactional
    public void updateOffer(Offer offer) {
        offerDAO.updateElement(offer);
    }

    @Override
    @Transactional
    public Offer getOfferById(int id) {
        return offerDAO.getElementById(id);
    }

    @Override
    @Transactional
    public void deleteOffer(Offer offer) {
        offerDAO.deleteElement(offer);
    }

    @Override
    @Transactional
    public List<Offer> getAllOffers() {
        return offerDAO.getAllElements();
    }

    @Override
    @Transactional
    public List<Offer> getAllOffersByPerfumeFilter(String perfumeName) {
        return offerDAO.getAllOffersByPerfumeFilter(perfumeName);
    }

    @Override
    @Transactional
    public List<Offer> getAllOffersByBrandFilter(String brandName) {
        return offerDAO.getAllOffersByBrandFilter(brandName);
    }
}
