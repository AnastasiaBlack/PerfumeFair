package com.softserve.edu.controller;

import com.softserve.edu.entity.Brand;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Perfume;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.service.BrandService;
import com.softserve.edu.service.CartService;
import com.softserve.edu.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class TableViewController {
    OfferService offerService = new OfferService();
    BrandService brandService = new BrandService();
    UserCartAction userCartAction = new UserCartAction();


    @RequestMapping("/brands")
    public String getBrands(Model model) {
        Set<Brand> allBrands = brandService.getAllBrands();
        model.addAttribute("brands", allBrands);
       return "/brandList";
    }

    @RequestMapping("/offers")
    public String getOffers(Model model){
        List<Offer> allOffers = offerService.getAllOffers();
        model.addAttribute("offers", allOffers);
        return "/allOffers";
    }

    @RequestMapping("/cart")
    public String showCart(Model model){
        List<Sale> cartContent= userCartAction.showCartContent();
//        if (cartContent.size()==0){
            return "/cartEmpty";
//        }
//!!!
//        model.addAttribute("offers", allOffers);
//        return "/allOffers";
    }
}
