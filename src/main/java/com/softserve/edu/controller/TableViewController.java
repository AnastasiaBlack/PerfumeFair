package com.softserve.edu.controller;

import com.softserve.edu.entity.Brand;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.service.BrandService;
import com.softserve.edu.service.OfferService;
import com.softserve.edu.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;


@Controller
public class TableViewController {
    OfferService offerService = new OfferService();
    BrandService brandService = new BrandService();
    UserCartAction userCartAction = new UserCartAction();
    private Integer salePrice;


    @RequestMapping("/brands")
    public String getBrands(Model model) {
        Set<Brand> allBrands = brandService.getAllBrands();
        model.addAttribute("brands", allBrands);
        return "/brandList";
    }

    @RequestMapping("/offers")
    public String getOffers(Model model) {
        List<Offer> allOffers = offerService.getAllOffers();
        model.addAttribute("offers", allOffers);
        return "/allOffers";
    }

    @RequestMapping("/sales")
    public String showCart(Model model) {
        this.salePrice = salePrice;
        List<Sale> cartContent = userCartAction.showCartContent();
        if (cartContent.size() == 0) {
            return "/cartEmpty";
        }

        model.addAttribute("sales", cartContent);
        return "/cartContent";
    }

    @RequestMapping("/deleteSaleFromCart")
    public String deleteSale(@RequestParam(value = "id") Integer id, Model
            model) {
        SaleService saleService = new SaleService();
        Sale saleToDelete = saleService.getSaleById(id);
        userCartAction.deletefromCart(saleToDelete);
        return showCart(model);
    }
}
