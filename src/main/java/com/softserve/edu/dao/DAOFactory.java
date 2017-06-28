package com.softserve.edu.dao;

import com.softserve.edu.dao.impl.*;
import org.springframework.beans.factory.annotation.Autowired;


public class DAOFactory {

    private BrandDAOImpl brandDAOImpl;
    private CartDAOImpl cartDAOImpl;
    private OfferDAOImpl offerDAOImpl;
    private PerfumeDAOImpl perfumeDAOImpl;
    private SaleDAOImpl saleDAOImpl;
    private UserDAOImpl userDAOImpl;
    private SubmittedOrderDAOImpl submittedOrderDAOImpl;

    private static DAOFactory instance;

    private DAOFactory() {
        brandDAOImpl = new BrandDAOImpl();
        cartDAOImpl = new CartDAOImpl();
        offerDAOImpl = new OfferDAOImpl();
        perfumeDAOImpl = new PerfumeDAOImpl();
        saleDAOImpl = new SaleDAOImpl();
        userDAOImpl = new UserDAOImpl();
        submittedOrderDAOImpl = new SubmittedOrderDAOImpl();
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            return instance = new DAOFactory();
        }
        return instance;
    }

    @Autowired
    public BrandDAOImpl getBrandDAOImpl() {
        return brandDAOImpl;
    }

    @Autowired
    public CartDAOImpl getCartDAOImpl() {
        return cartDAOImpl;
    }

    @Autowired
    public OfferDAOImpl getOfferDAOImpl() {
        return offerDAOImpl;
    }

    @Autowired
    public PerfumeDAOImpl getPerfumeDAOImpl() {
        return perfumeDAOImpl;
    }

    @Autowired
    public UserDAOImpl getUserDAOImpl() {
        return userDAOImpl;
    }

    @Autowired
    public SaleDAOImpl getSaleDAOImpl() {
        return saleDAOImpl;
    }

    @Autowired
    public SubmittedOrderDAOImpl getSubmittedOrderDAOImpl() {
        return submittedOrderDAOImpl;
    }
}