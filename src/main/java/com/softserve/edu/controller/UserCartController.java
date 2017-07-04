package com.softserve.edu.controller;

import com.softserve.edu.controller.auxiliary.TempOfferIdVolumeOrdered;
import com.softserve.edu.entity.*;
import com.softserve.edu.perspective.user.UserCartAction;
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

@Controller
public class UserCartController {
    private ServiceFactory serviceFactory = new ServiceFactory();
    private CartService cartService;
    private UserService userService;
    private UserCartAction userCartAction = new UserCartAction(serviceFactory);

    @Autowired
    public UserCartController(ServiceFactory serviceFactory) {
        this.cartService = serviceFactory.getCartService();
        this.userService = serviceFactory.getUserService();

    }


    @RequestMapping("/sales")
    public String showCart(Model model) {
        Cart cart = userCartAction.getUserCart();
        List<Sale> cartContent = cart.getSales();
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
        userCartAction.deletefromCart(id);
        return showCart(model);
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute("offer") TempOfferIdVolumeOrdered
                                    temp,
                            BindingResult result,
                            Model model) {
        int offerId= temp.getId();
        model.addAttribute("volumeOrdered", temp.getVolumeOrdered());

        userCartAction.addToCart(offerId, temp.getVolumeOrdered());

        String pageMessage = "Added new item to the cart";
        model.addAttribute("pageMessage", pageMessage);
        return "/stringMessage";
    }

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
}
