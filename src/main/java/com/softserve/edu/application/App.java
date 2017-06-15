package com.softserve.edu.application;

import com.softserve.edu.entity.Offer;
import com.softserve.edu.perspective.seller.SellerOfferOperation;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.perspective.user.UserSearchMode;


public class App {
    public static void main(String[] args) {

        UserSearchMode usearch = new UserSearchMode();
        SellerOfferOperation sellerOffer = new SellerOfferOperation();
        Offer offer = sellerOffer.createOffer("Lalique", "Commedia", "60",
                "26");
      //  Offer offer1 = sellerOffer.createOffer("Givenchy", "Ange ou Demon", "60",
                "10");
//
//
//        UserCartAction userCartAction = new UserCartAction();
//        userCartAction.addToCart(offer1,"15");
//        userCartAction.addToCart(offer2,"10");
//
//        userCartAction.showCartContent();


//        usearch.showOffersByBrand("sergio lutens");
//        usearch.showOffersByPerfume("Le secret");
//        sellerOffer.updateOffer(offer,"","L'Amour","","");
//        sellerOffer.deleteOffer(offer);
//         usearch.showOffers();
    }
}