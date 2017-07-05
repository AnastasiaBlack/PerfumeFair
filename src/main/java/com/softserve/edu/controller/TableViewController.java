package com.softserve.edu.controller;

import com.softserve.edu.controller.auxiliary.TransitSearchByBrandAndPriceData;
import com.softserve.edu.entity.Brand;
import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


@Controller
public class TableViewController {
    private ServiceFactory serviceFactory = new ServiceFactory();
    private OfferService offerService;
    private BrandService brandService;
    private SaleService saleService;
    private CartService cartService;
    private UserService userService;
    private UserCartAction userCartAction = new UserCartAction(serviceFactory);
    private Cart cart = userCartAction.getUserCart();

    @Autowired
    public TableViewController(ServiceFactory serviceFactory) {
        this.offerService = serviceFactory.getOfferService();
        this.brandService = serviceFactory.getBrandService();
        this.saleService = serviceFactory.getSaleService();
        this.cartService = serviceFactory.getCartService();
        this.userService = serviceFactory.getUserService();

    }


    @RequestMapping("/brands")
    public String getBrands(Model model) {
        Set<Brand> allBrands = brandService.getAllBrands();
        model.addAttribute("brands", allBrands);
        return "/brandList";
    }

    @RequestMapping("/offers")
    public String getOffers(Model model) {
        model.addAttribute("tempData", new TransitSearchByBrandAndPriceData());
        List<Offer> allOffers = offerService.getAllOffers();
        allOffers.sort(Comparator.comparingInt(Offer::getPricePerMl));
        model.addAttribute("offers", allOffers);
        return "/allOffers";
    }

    @RequestMapping("/homepage")
    public String goHome(Model model) {

        return "/homepage";
    }


    @RequestMapping("/seeDetails")
    public String seeDetails(@RequestParam(value = "id") Integer id, Model
            model) {
        Offer offer = offerService.getOfferById(id);
        model.addAttribute("offer", offer);

        return "offerDetail";
    }


}
