package com.softserve.edu.dao;

import com.softserve.edu.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class DAOFactory {
    private BrandDAO brandDAO;
    private CartDAO cartDAO;
    private OfferDAO offerDAO;
    private PerfumeDAO perfumeDAO;
    private SaleDAO saleDAO;
    private UserDAO userDAO;
    private SubmittedOrderDAO submittedOrderDAO;

    private static DAOFactory instance;

    private DAOFactory() {
        brandDAO = new BrandDAO();
        cartDAO = new CartDAO();
        offerDAO = new OfferDAO();
        perfumeDAO = new PerfumeDAO();
        saleDAO = new SaleDAO();
        userDAO = new UserDAO();
        submittedOrderDAO = new SubmittedOrderDAO();
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            return instance = new DAOFactory();
        }
        return instance;
    }

    @Autowired
    public BrandDAO getBrandDAO() {
        return brandDAO;
    }

    @Autowired
    public CartDAO getCartDAO() {
        return cartDAO;
    }

    @Autowired
    public OfferDAO getOfferDAO() {
        return offerDAO;
    }

    @Autowired
    public PerfumeDAO getPerfumeDAO() {
        return perfumeDAO;
    }

    @Autowired
    public SaleDAO getSaleDAO() {
        return saleDAO;
    }

    @Autowired
    public SubmittedOrderDAO getSubmittedOrderDAO() {
        return submittedOrderDAO;
    }
    }