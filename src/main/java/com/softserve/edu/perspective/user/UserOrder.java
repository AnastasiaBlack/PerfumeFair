package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.service.OfferService;

import java.security.InvalidParameterException;

public class UserOrder {
    private Cart cart;
    private Sale sale;
    private Offer offer;

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

}
