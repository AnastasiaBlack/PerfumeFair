package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.*;
import com.softserve.edu.service.OfferService;
import com.softserve.edu.service.SaleService;
import com.softserve.edu.service.SubmittedOrderService;

import java.security.InvalidParameterException;
import java.util.List;

public class UserOrder {
    private Cart cart;
    private Sale sale;
    private Offer offer;
    private SubmittedOrder submittedOrder;
    private SaleService saleService = new SaleService();
    private UserCartAction userCartAction = new UserCartAction();


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

    public void order(Cart cart){
        SubmittedOrder newOrder = new SubmittedOrder();
        User user = cart.getUser();
        newOrder.setUser(user);
        int price = userCartAction.countTotalPrice();
        newOrder.setTotalPrice(price);
        SubmittedOrderService submittedOrderService = new SubmittedOrderService();
        submittedOrderService.addSubmittedOrder(newOrder);
        List<Sale> salesToSubmit = cart.getSales();

        for(Sale s: salesToSubmit){
            s.setSubmittedOrder(newOrder);
            saleService.updateSale(s);
            decreaseOfferVolumeBySale(s);
        }
        newOrder.setSales(salesToSubmit);
        submittedOrderService.updateSubmittedOrder(newOrder);

        emptyCart(cart);
    }

    public void emptyCart(Cart cart){
        List<Sale> salesToSubmit = cart.getSales();
        for(Sale s: salesToSubmit){
            s.setCart(null);
            saleService.updateSale(s);
        }
        salesToSubmit.clear();
    }



}
