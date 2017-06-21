package com.softserve.edu.controller;

import com.softserve.edu.entity.Brand;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.service.BrandService;
import com.softserve.edu.service.OfferService;
import com.softserve.edu.service.SaleService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping("/seeDetails")
    public String seeDetails(@RequestParam(value = "id") Integer id, Model
            model) {
        Offer offer = offerService.getOfferById(id);
        model.addAttribute("offer", offer);

        return "offerDetail";
    }

    @RequestMapping(value="/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute("offer") CMDBean cmd, BindingResult result,
                            ModelMap model) {
        Offer offer1 = offerService.getOfferById(cmd.getId());
        model.addAttribute("volumeOrdered", cmd.getVolumeOrdered());
        userCartAction.addToCart(offer1, cmd.getVolumeOrdered());
        return "/cartContent";
    }

    @RequestMapping(value="/offerDetail")
    public String renderCMDBean(Model model){
        CMDBean offer = new CMDBean();
        model.addAttribute("offer", offer);
        return "offerDetail";

    }



}
