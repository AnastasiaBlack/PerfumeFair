package com.softserve.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {
    @Autowired
    private static OfferService offerService;
    @Autowired
    private static BrandService brandService;
    @Autowired
    private static SaleService saleService;
    @Autowired
    private static CartService cartService;
    @Autowired
    private static UserService userService;
    @Autowired
    private static PerfumeService perfumeService;
    @Autowired
    private static SecurityService securityService;
    @Autowired
    private static SubmittedOrderService submittedOrderService;

    public SubmittedOrderService getSubmittedOrderService() {
        return submittedOrderService;
    }

    @Autowired
    public void setSubmittedOrderService(SubmittedOrderService
                                                 submittedOrderService) {
        this.submittedOrderService = submittedOrderService;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }


    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    public PerfumeService getPerfumeService() {
        return perfumeService;
    }

    @Autowired
    public void setPerfumeService(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    public OfferService getOfferService() {
        return offerService;
    }

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    public BrandService getBrandService() {
        return brandService;
    }

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    public SaleService getSaleService() {
        return saleService;
    }

    @Autowired
    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }

    public CartService getCartService() {
        return cartService;
    }

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
