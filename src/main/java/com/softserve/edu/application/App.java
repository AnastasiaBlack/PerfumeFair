package com.softserve.edu.application;

import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.perspective.seller.SellerOfferOperation;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.perspective.user.UserSearchMode;


public class App {
    public static void main(String[] args) {

        UserSearchMode usearch = new UserSearchMode();
//        SellerOfferOperation sellerOffer = new SellerOfferOperation();
//        Offer offer1 = sellerOffer.createOffer("Lalique", "Commedia", "60",
//                "26");
//        Offer offer2 = sellerOffer.createOffer("Givenchy", "Ange ou Demon",
//                "60",
//                "10");
//
//
        UserCartAction userCartAction = new UserCartAction();
//        Sale sale1 = userCartAction.addToCart(offer1, "15");
//        Sale sale2 = userCartAction.addToCart(offer2, "10");
//
//        userCartAction.showCartContent();


//        usearch.showOffersByBrand("sergio lutens");
//        usearch.showOffersByPerfume("Le secret");
//        sellerOffer.updateOffer(offer,"","L'Amour","","");
//        sellerOffer.deleteOffer(offer);
//         usearch.showOffers();
//        System.out.println("TOTAL PRICE: "+userCartAction.countTotalPrice());
//        userCartAction.deletefromCart(sale1);
        //В базе обновление общего обьема не произошло
        userCartAction.showCartContent();
        usearch.showOffersByPerfume("ange ou demon");

    }
}