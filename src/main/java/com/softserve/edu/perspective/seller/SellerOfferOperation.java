package com.softserve.edu.perspective.seller;

import com.softserve.edu.entity.Brand;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Perfume;
import com.softserve.edu.service.BrandService;
import com.softserve.edu.service.OfferService;
import com.softserve.edu.service.PerfumeService;
import com.softserve.edu.service.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SellerOfferOperation {
    private ServiceFactory serviceFactory;
    private OfferService offerService;
    private BrandService brandService;
    private PerfumeService perfumeService;

    @Autowired
    public SellerOfferOperation(ServiceFactory serviceFactory) {
        this.brandService=serviceFactory.getBrandService();
        this.perfumeService=serviceFactory.getPerfumeService();
        this.offerService = serviceFactory.getOfferService();
    }

    @Transactional
    public void createOffer(String newBrandName, String perfumeName, String
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
        brandService.addBrand(brand);
        perfumeService.addPerfume(perfume);
        offerService.addOffer(offer);
    }

    @Transactional
    public void deleteOffer(int offerId) {
        Offer offer = offerService.getOfferById(offerId);
        offerService.deleteOffer(offer);
    }

    @Transactional
    public void updateOffer(int offerId, String newBrandName, String newPerfumeName, String volumeForSale, String pricePerMl) {
        Offer offer = offerService.getOfferById(offerId);
        Brand brandUpdate = offer.getPerfume().getBrand();
        if (newBrandName.equals("")) {
            newBrandName = brandUpdate.getName();
        }
        brandUpdate.setName(newBrandName);
        brandService.updateBrand(brandUpdate);

        Perfume perfumeUpdate = offer.getPerfume();
        if (newPerfumeName.equals("")) {
            newPerfumeName = perfumeUpdate.getName();
        }
        perfumeUpdate.setName(newPerfumeName);
        perfumeUpdate.setBrand(brandUpdate);
        perfumeService.updatePerfume(perfumeUpdate);

        if (volumeForSale.equals("")) {
            volumeForSale = String.valueOf(offer.getVolumeForSale());
        }
        if (pricePerMl.equals("")) {
            pricePerMl = String.valueOf(offer.getPricePerMl());
        }
        offer.setPerfume(perfumeUpdate);
        offer.setVolumeForSale(volumeForSale);
        offer.setPricePerMl(pricePerMl);
        offerService.updateOffer(offer);
    }
}
