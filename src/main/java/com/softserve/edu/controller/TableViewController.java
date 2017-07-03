package com.softserve.edu.controller;

import com.softserve.edu.controller.auxiliary.TempOfferIdVolumeOrdered;
import com.softserve.edu.entity.*;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.perspective.user.UserSearchMode;
import com.softserve.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
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
        List<Offer> allOffers = offerService.getAllOffers();
        model.addAttribute("offers", allOffers);
        return "/allOffers";
    }

    @RequestMapping("/homepage")
    public String goHome(Model model) {

        return "/homepage";
    }

    @RequestMapping("/sales")
    public String showCart(Model model) {
        Cart cart = userCartAction.getUserCart();
        List<Sale> cartContent = saleService.getAllSalesFromCart(cart);
        if (cartContent.size() == 0) {
            String message = "Your cart is empty...add something and smell " +
                    "good)))";
            model.addAttribute("pageMessage", message);
            return "stringMessage";
        }
        model.addAttribute("cart", cart);
        model.addAttribute("cartContent", cartContent);
        return "cartContent";
    }

    @RequestMapping("/deleteSaleFromCart")
    public String deleteSale(@RequestParam(value = "id") Integer id, Model
            model) {
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

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute("offer") TempOfferIdVolumeOrdered
                                    temp,
                            BindingResult result,
                            Model model) {
        Offer offer1 = offerService.getOfferById(temp.getId());
        model.addAttribute("volumeOrdered", temp.getVolumeOrdered());

        userCartAction.addToCart(offer1, temp.getVolumeOrdered());

        String pageMessage = "Added new item to the cart";
        model.addAttribute("pageMessage", pageMessage);
        return "/stringMessage";
    }

//    @RequestMapping(value="/offerDetail")
//    public String renderCMDBean(Model model){
//        CMDBean offer = new CMDBean();
//        model.addAttribute("offer", offer);
//        return "offerDetail";
//    }


    @RequestMapping("/makeOrder")
    public String makeOrder(@RequestParam(value = "id") Integer id, Model
            model) {
        Cart cart = cartService.getCartById(id);
        model.addAttribute("cart", cart);
        return "Order";
    }


    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST)
    public String submitOrder(@RequestParam(value = "id") Integer id,
                              Principal principal,
                              Model model) {
        Cart cart = userCartAction.getUserCart();
        int priceCurrent = userCartAction.countTotalPrice();
        userCartAction.order(cart);
        User user = userService.findByUsername(principal.getName());
        List<SubmittedOrder> allOrders = user.getUserOrdersList();
        model.addAttribute("allOrders", allOrders);
        String pageMessage = "Дякуємо, ви успішно оформили замовлення " +
                "Загальною сумою " + priceCurrent + " UAH";
        model.addAttribute("pageMessage", pageMessage);
        return "SubmittedOrder";
    }

    @RequestMapping(value = "/showOffersByBrand", method = RequestMethod.POST)
    public String showOffersByBrand(@RequestParam(value = "brandName") String
                                            brandName, Model model) {

        UserSearchMode userSearchMode = new UserSearchMode(offerService);
        List<Offer> allOffersByBrand = userSearchMode.showOffersByBrand
                (brandName);

        model.addAttribute("offers", allOffersByBrand);
        model.addAttribute("brandName",brandName);
        return "/ShowFilteredOffers";
    }


}
