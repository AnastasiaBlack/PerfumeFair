package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.*;
import com.softserve.edu.service.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserOrder {
    private SubmittedOrderService submittedOrderService = new SubmittedOrderService();
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


        int price = userCartAction.countTotalPrice();
        List<Sale> salesToSubmit = new ArrayList<>(cart.getSales());

        newOrder.setUser(user);
        newOrder.setTotalPrice(price);


        newOrder.setSales(salesToSubmit);
        submittedOrderService.addSubmittedOrder(newOrder);

//        submittedOrderService.updateSubmittedOrder(newOrder);
        user.addOrder(newOrder);
        userService.updateUser(user);
        salesTransfer(cart, newOrder);
        userService.updateUser(user);

    }

    public void salesTransfer(Cart cart, SubmittedOrder newOrder) {
        List<Sale> salesToSubmit = cart.getSales();
        Iterator<Sale> iterator = salesToSubmit.iterator();
        while(iterator.hasNext()){
            Sale s = iterator.next();
            s.setSubmittedOrders(newOrder);
            s.setCart(null);
            saleService.updateSale(s);
            decreaseOfferVolumeBySale(s);
        }
        submittedOrderService.updateSubmittedOrder(newOrder);
        cartService.updateCart(cart);
    }


}
