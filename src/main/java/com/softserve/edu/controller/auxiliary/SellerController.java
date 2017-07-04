package com.softserve.edu.controller.auxiliary;

import com.softserve.edu.entity.Offer;
import com.softserve.edu.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SellerController {
    private OfferService offerService;

    SellerController(OfferService offerService){
        this.offerService=offerService;
    }

    @RequestMapping("/editOffer")
    public String seeDetails(@RequestParam(value = "id") Integer id, Model
            model) {
        Offer offer = offerService.getOfferById(id);
        model.addAttribute("offer", offer);

        return "admin";
    }
}
