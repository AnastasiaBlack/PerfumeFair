package com.softserve.edu.service.impl;

import com.softserve.edu.dao.OfferDAO;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferDAO offerDAO;

    @Autowired
    public void setOfferDAO(OfferDAO offerDAO) {
        this.offerDAO = offerDAO;
    }

    @Transactional
    @Override
    public void addOffer(Offer offer) {
        offerDAO.addElement(offer);

//        DAOFactory.getInstance().getOfferDAOImpl().addElement(offer);
    }

    @Transactional
    @Override
    public void updateOffer(Offer offer) {
        offerDAO.updateElement(offer);
//        DAOFactory.getInstance().getOfferDAOImpl().updateElement(offer);
    }

    @Transactional
    @Override
    public Offer getOfferById(int id) {
        return offerDAO.getElementById(id);
//        Offer offer = DAOFactory.getInstance().getOfferDAOImpl()
// .getElementById(id);
//        return offer;
    }

    @Transactional
    @Override
    public void deleteOffer(Offer offer) {
        offerDAO.deleteElement(offer);
//        DAOFactory.getInstance().getOfferDAOImpl().deleteElement(offer);
    }

    @Transactional
    @Override
    public List<Offer> getAllOffers() {
        return offerDAO.getAllElements();
//        return DAOFactory.getInstance().getOfferDAOImpl().getAllElements();
    }

    @Transactional
    @Override
    public List<Offer> getAllOffersByPerfumeFilter(String perfumeName) {
        return offerDAO.getAllOffersByPerfumeFilter(perfumeName);
//        return DAOFactory.getInstance().getOfferDAOImpl()
// .getAllOffersByPerfumeFilter(perfumeName);
    }

    @Transactional
    @Override
    public List<Offer> getAllOffersByBrandFilter(String brandName) {
        return offerDAO.getAllOffersByBrandFilter(brandName);
//        return DAOFactory.getInstance().getOfferDAOImpl()
// .getAllOffersByBrandFilter(brandName);
    }
}
