package com.softserve.edu.controller;

import com.softserve.edu.controller.auxiliary.TransitSearchByBrandAndPriceData;
import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.perspective.user.UserSearchMode;
import com.softserve.edu.service.*;
import com.softserve.edu.validator.SearchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@Controller
public class SearchController {
    private ServiceFactory serviceFactory = new ServiceFactory();
    private OfferService offerService;
    private SaleService saleService;
    private CartService cartService;
    private UserService userService;
    private UserCartAction userCartAction = new UserCartAction(serviceFactory);
    private Cart cart = userCartAction.getUserCart();

    @Autowired
    public SearchController(ServiceFactory serviceFactory) {
        this.offerService = serviceFactory.getOfferService();
        this.saleService = serviceFactory.getSaleService();
        this.cartService = serviceFactory.getCartService();
        this.userService = serviceFactory.getUserService();

    }


    @RequestMapping(value = "/showOffersByBrand", method = RequestMethod.POST)
    public String showOffersByBrand(@RequestParam(value = "brandName") String
                                            brandName, Model model) {

        UserSearchMode userSearchMode = new UserSearchMode(offerService);
        List<Offer> allOffersByBrand = userSearchMode.showOffersByBrand
                (brandName);

        model.addAttribute("offers", allOffersByBrand);
        model.addAttribute("brandName", brandName);
        return "/ShowFilteredOffers";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String userSearch(@RequestParam(value = "searchString") String
                                     searchString, Model model) {
        UserSearchMode userSearchMode = new UserSearchMode(offerService);
        List<Offer> allOffersByPerfume = userSearchMode.showOffersByPerfume
                (searchString);
        if (allOffersByPerfume.size() == 0) {
            String message = "Жодних збігів не знайдено";
            model.addAttribute("pageMessage", message);
            return "stringMessage";
        }
        allOffersByPerfume.sort(Comparator.comparingInt(Offer::getPricePerMl));

        model.addAttribute("offers", allOffersByPerfume);
        model.addAttribute("searchName", searchString);
        return "/ShowFilteredOffers";
    }

    @RequestMapping("/filterByBrandAndPrice")
    public String getByBrandAndPrice(@ModelAttribute("tempData")                                     TransitSearchByBrandAndPriceData tempData,
                                     BindingResult bindingResult,
                                     Model model) {
        SearchValidator inputValidator = new SearchValidator();

        inputValidator.validate(tempData, bindingResult);

        if (bindingResult.hasErrors()) {
            return new TableViewController(serviceFactory).getOffers(model);
        }
        List<Offer> offers = offerService.getAllOffersByBrandAndPriceFilter
                (tempData.getBrandName(), Integer.valueOf(tempData.getMaxPrice()));

        if (offers.size() == 0) {
            String message = "Жодних збігів не знайдено";
            model.addAttribute("pageMessage", message);
            return "stringMessage";
        }
        model.addAttribute("offers", offers);
        model.addAttribute("searchName", tempData.getBrandName());
        return "/ShowFilteredOffers";
    }
}
