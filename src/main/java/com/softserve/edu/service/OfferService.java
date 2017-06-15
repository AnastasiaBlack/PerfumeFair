package com.softserve.edu.service;

import com.softserve.edu.dao.DAOFactory;
import com.softserve.edu.entity.Offer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class OfferService {
    @Transactional
    public void addOffer(Offer offer) {
        DAOFactory.getInstance().getOfferDAO().addElement(offer);
    }

    @Transactional
    public void updateOffer(Offer offer) {
        DAOFactory.getInstance().getOfferDAO().updateElement(offer);
    }

    @Transactional
    public Offer getOfferById(int id) {
        Offer offer = DAOFactory.getInstance().getOfferDAO().getElementById(id);
        return offer;
    }
    @Transactional
    public void deleteOffer(Offer offer) {
        DAOFactory.getInstance().getOfferDAO().deleteElement(offer);
    }

    @Transactional
    public List<Offer> getAllOffers() {
        return DAOFactory.getInstance().getOfferDAO().getAllElements();
    }

    @Transactional
    public List<Offer> getAllOffersByPerfumeFilter(String perfumeName) {
        return DAOFactory.getInstance().getOfferDAO().getAllOffersByPerfumeFilter(perfumeName);
    }

    @Transactional
    public List<Offer> getAllOffersByBrandFilter(String brandName) {
        return DAOFactory.getInstance().getOfferDAO().getAllOffersByBrandFilter(brandName);
    }
}
