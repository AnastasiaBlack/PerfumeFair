package com.softserve.edu.controller;

import com.softserve.edu.entity.*;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.service.BrandService;
import com.softserve.edu.service.CartService;
import com.softserve.edu.service.OfferService;
import com.softserve.edu.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    CartService cartService= new CartService();
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
            String message = "Your cart is empty...add something and smell good)))";
            model.addAttribute("pageMessage", message);
            return "stringMessage";
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
                            Model model) {
        Offer offer1 = offerService.getOfferById(cmd.getId());
        model.addAttribute("volumeOrdered", cmd.getVolumeOrdered());
        userCartAction.addToCart(offer1, cmd.getVolumeOrdered());
        String message = "Ваша покупка успішно додана до кошика.";
        model.addAttribute("pageMessage",message);
        return "stringMessage";
    }

    @RequestMapping(value="/offerDetail")
    public String renderCMDBean(Model model){
        CMDBean offer = new CMDBean();
        model.addAttribute("offer", offer);
        return "offerDetail";

    }

    @RequestMapping("/makeOrder")
    public String makeOrder(@RequestParam(value="id") String id, Model model){
        Cart cart = cartService.getCartById(Integer.valueOf(id));
        model.addAttribute("cart", cart);
        return "Order";
    }

    @RequestMapping("/submitOrder")
    public String submitOrder(@ModelAttribute ("userInfo") User user, @RequestParam(value="cart") Cart cart, Model model){
        cart.setUser(user);
        model.addAttribute("cart", cart);
        model.addAttribute("user", user);
        return "SubmittedOrder";
    }



}
