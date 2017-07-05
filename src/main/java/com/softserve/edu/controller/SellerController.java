package com.softserve.edu.controller;

import com.softserve.edu.controller.auxiliary.TransitOffer;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.SubmittedOrder;
import com.softserve.edu.perspective.seller.SellerOfferOperation;
import com.softserve.edu.service.OfferService;
import com.softserve.edu.service.ServiceFactory;
import com.softserve.edu.service.SubmittedOrderService;
import com.softserve.edu.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SellerController {
    private OfferService offerService;
    private SubmittedOrderService submittedOrderService;
    private ServiceFactory serviceFactory = new ServiceFactory();

    private SellerOfferOperation sellerOfferOperation = new
            SellerOfferOperation(serviceFactory);

    @Autowired
    public SellerController(ServiceFactory serviceFactory) {
        this.offerService = serviceFactory.getOfferService();
        this.submittedOrderService=serviceFactory.getSubmittedOrderService();
    }

    @RequestMapping("/editOffer")
    public String seeDetails(@RequestParam(value = "id") Integer id, Model
            model) {
        Offer offer = offerService.getOfferById(id);
        model.addAttribute("offer", offer);
        model.addAttribute("title", "Редагувати");

        return "editOffer";
    }

    @RequestMapping(value = "/submitEditedOrder", method = RequestMethod.POST)
    public String editOrder(@RequestParam("perfumeName") String perfumeName,
                            @RequestParam("brandName") String brandName,
                            @RequestParam("price") String price,
                            @RequestParam("volumeForSale") String volumeForSale,
                            @RequestParam("id") Integer id,
                            Model model) {
        sellerOfferOperation.updateOffer(id, brandName, perfumeName,
                volumeForSale, price);
        return new TableViewController(serviceFactory).getOffers(model);
    }

    @RequestMapping(value = "/addNewOffer", method = RequestMethod.GET)
    public String getCreateForm(Model model) {
        model.addAttribute("tempOffer", new TransitOffer());

        model.addAttribute("title", "Додати нову позицію для продажу:");
        return "newOfferForm";
    }


    @RequestMapping(value = "/submitNewOffer", method = RequestMethod.POST)
    public String createNewOffer(@ModelAttribute("tempOffer") TransitOffer
                                             tempOffer,
                                 BindingResult bindingResult,
                                 Model model) {
        InputValidator inputValidator = new InputValidator();

        inputValidator.validate(tempOffer, bindingResult);

        if (bindingResult.hasErrors()) {
            return "newOfferForm";
        }

        sellerOfferOperation.createOffer(tempOffer.getBrandName(), tempOffer
                .getPerfumeName(), tempOffer.getVolumeForSale(), tempOffer
                .getPrice());
        return new TableViewController(serviceFactory).getOffers(model);
    }


    @RequestMapping(value = "/showOrders", method = RequestMethod.GET)
    public String showAllOrders(Model model) {
        List<SubmittedOrder> allOrders = submittedOrderService.getAllSubmittedOrders();
        model.addAttribute("allOrders", allOrders);

        return "/ShowAllOrders";
    }

}
