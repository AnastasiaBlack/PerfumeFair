package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.Offer;
import com.softserve.edu.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSearchMode {
    private final OfferService offerService;
    private List<Offer> currentOffersList;

    @Autowired
    public UserSearchMode(OfferService offerService) {
        this.offerService = offerService;
    }


    public void showOffers() {
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


    public void sortByPrice() {

    }


}
