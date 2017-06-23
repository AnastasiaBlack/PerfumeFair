package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.*;
import com.softserve.edu.service.*;

import java.security.InvalidParameterException;
import java.util.List;

public class UserOrder {
    private Cart cart;
    private Sale sale;
    private Offer offer;
    private SubmittedOrder submittedOrder;
    private SaleService saleService = new SaleService();
    private UserCartAction userCartAction = new UserCartAction();
    private UserService userService = new UserService();
    private CartService cartService = new CartService();


    public void decreaseOfferVolumeBySale(Sale sale) {
        Offer offer = sale.getOffer();
        String updateVol;
        int volumeOffer = offer.getVolumeForSale();
        int volumeBought = sale.getVolumeOrdered();
        int updateOfferVolume = volumeOffer - volumeBought;
        if (volumeBought > volumeOffer) {
            System.out.println("Sorry, but we have only " + volumeOffer + " " +
                    "ml left.");
            updateOfferVolume = volumeOffer;
        }
        offer.setVolumeForSale(String.valueOf(updateOfferVolume));
        OfferService offerService = new OfferService();
        offerService.updateOffer(offer);
    }

    public void order(Cart cart) {
        SubmittedOrderService submittedOrderService = new
                SubmittedOrderService();
        SubmittedOrder newOrder = new SubmittedOrder();
        User user = cart.getUser();
        userService.addUser(user);

        int price = userCartAction.countTotalPrice();
        List<Sale> salesToSubmit = cart.getSales();

        newOrder.setUser(user);
        newOrder.setTotalPrice(price);


        newOrder.setSales(salesToSubmit);
        submittedOrderService.addSubmittedOrder(newOrder);

        submittedOrderService.updateSubmittedOrder(newOrder);
        salesTransfer(cart, newOrder);
        user.addOrder(newOrder);
        userService.updateUser(user);

    }

    public void salesTransfer(Cart cart, SubmittedOrder newOrder) {
        List<Sale> salesToSubmit = cart.getSales();
        for (Sale s : salesToSubmit) {
            s.setSubmittedOrders(newOrder);
            s.setCart(null);
            saleService.updateSale(s);
            newOrder.getSales().add(s);
            decreaseOfferVolumeBySale(s);
        }
        salesToSubmit.clear();
        cartService.updateCart(cart);
    }


}
