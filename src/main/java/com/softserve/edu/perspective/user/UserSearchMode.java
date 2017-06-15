package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Perfume;
import com.softserve.edu.service.OfferService;

import java.util.List;

public class UserSearchMode {
    private OfferService offerService;
    private List<Offer> currentOffersList;


    public void showOffers() {
        offerService = new OfferService();
        currentOffersList = offerService.getAllOffers();
        System.out.println("-------------------------------------------------" +
                "\nPerfume\t\t Brand\t\t Price per ml \t Volume for Sale\n" +
                "-------------------------------------------------");
        for (Offer o: currentOffersList) {
            System.out.print(o.getPerfume().getName() + "\t " + o.getPerfume().getBrand().getName() + "\t " +
                    o.getPricePerMl() + "\t\t\t\t " + o.getVolumeForSale() + "\n");
        }
    }

    public List<Offer> showOffersByPerfume(String perfumeName) {
        offerService = new OfferService();
        currentOffersList = offerService.getAllOffersByPerfumeFilter(perfumeName);
        System.out.println("-------------------------------------------------" +
                "\nPerfume\t\t Brand\t\t Price per ml \t Volume for Sale\n" +
                "-------------------------------------------------");
        for (Offer o : currentOffersList) {
            System.out.print(o.getPerfume().getName() + "\t\t\t " + o.getPerfume().getBrand().getName() + "\t\t\t " +
                    o.getPricePerMl() + "\t\t\t\t " + o.getVolumeForSale() + "\n");
        }
        return currentOffersList;
    }

    public List<Offer> showOffersByBrand(String brandName) {
        offerService = new OfferService();
        currentOffersList = offerService.getAllOffersByBrandFilter(brandName);
        System.out.println("-------------------------------------------------" +
                "\nPerfume\t\t Brand\t\t Price per ml \t Volume for Sale\n" +
                "-------------------------------------------------");
        for (Offer o : currentOffersList) {
            System.out.print(o.getPerfume().getName() + "\t\t\t " + o.getPerfume().getBrand().getName() + "\t\t\t " +
                    o.getPricePerMl() + "\t\t\t\t " + o.getVolumeForSale() + "\n");
        }
        return currentOffersList;
    }

    public void showOffers(Perfume perfume) {

    }

    public void sortByPrice() {

    }


}
