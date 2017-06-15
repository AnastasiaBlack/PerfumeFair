package com.softserve.edu.perspective.seller;

import com.softserve.edu.entity.Brand;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Perfume;
import com.softserve.edu.perspective.user.UserSearchMode;
import com.softserve.edu.service.BrandService;
import com.softserve.edu.service.OfferService;
import com.softserve.edu.service.PerfumeService;

import java.util.List;

public class SellerOfferOperation {

    public Offer createOffer(String newBrandName, String perfumeName, String
            volumeForSale, String pricePerMl) {
        Brand brand = new Brand();
        brand.setName(newBrandName);
        Perfume perfume = new Perfume();
        perfume.setName(perfumeName);
        perfume.setBrand(brand);
        Offer offer = new Offer();
        offer.setPerfume(perfume);
        offer.setVolumeForSale(volumeForSale);
        offer.setPricePerMl(pricePerMl);
        PerfumeService perfumeService = new PerfumeService();
        BrandService brandService = new BrandService();
        OfferService offerService = new OfferService();
        brandService.addBrand(brand);
        perfumeService.addPerfume(perfume);
        offerService.addOffer(offer);
        return offer;
    }

    public void deleteOffer(Offer offer) {
        OfferService offerService = new OfferService();
        offerService.deleteOffer(offer);
    }

    public void updateOffer(Offer offer, String newBrandName, String
            perfumeName, String
            volumeForSale, String pricePerMl) {
        Brand brandUpdate = offer.getPerfume().getBrand();
        if (newBrandName.equals("")) {
            newBrandName = brandUpdate.getName();
        }
        brandUpdate.setName(newBrandName);
        BrandService bs = new BrandService();
        bs.updateBrand(brandUpdate);

        Perfume perfumeUpdate = offer.getPerfume();
        if (perfumeUpdate.getName().equals("")) {
            perfumeName = perfumeUpdate.getName();
        }
        perfumeUpdate.setName(perfumeName);
        PerfumeService ps = new PerfumeService();
        ps.updatePerfume(perfumeUpdate);

        if (volumeForSale.equals("")) {
            volumeForSale = String.valueOf(offer.getVolumeForSale());
        }
        if (pricePerMl.equals("")) {
            pricePerMl = String.valueOf(offer.getPricePerMl());
        }
        offer.setVolumeForSale(volumeForSale);
        offer.setPricePerMl(pricePerMl);
        OfferService os = new OfferService();
        os.updateOffer(offer);
    }
}
