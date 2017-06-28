package com.softserve.edu.perspective.seller;

import com.softserve.edu.entity.Brand;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Perfume;
import com.softserve.edu.service.impl.BrandServiceImpl;
import com.softserve.edu.service.impl.OfferServiceImpl;
import com.softserve.edu.service.impl.PerfumeServiceImpl;

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
        PerfumeServiceImpl perfumeService = new PerfumeServiceImpl();
        BrandServiceImpl brandService = new BrandServiceImpl();
        OfferServiceImpl offerService = new OfferServiceImpl();
        brandService.addBrand(brand);
        perfumeService.addPerfume(perfume);
        offerService.addOffer(offer);
        return offer;
    }

    public void deleteOffer(Offer offer) {
        OfferServiceImpl offerService = new OfferServiceImpl();
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
        BrandServiceImpl bs = new BrandServiceImpl();
        bs.updateBrand(brandUpdate);

        Perfume perfumeUpdate = offer.getPerfume();
        if (perfumeUpdate.getName().equals("")) {
            perfumeName = perfumeUpdate.getName();
        }
        perfumeUpdate.setName(perfumeName);
        PerfumeServiceImpl ps = new PerfumeServiceImpl();
        ps.updatePerfume(perfumeUpdate);

        if (volumeForSale.equals("")) {
            volumeForSale = String.valueOf(offer.getVolumeForSale());
        }
        if (pricePerMl.equals("")) {
            pricePerMl = String.valueOf(offer.getPricePerMl());
        }
        offer.setVolumeForSale(volumeForSale);
        offer.setPricePerMl(pricePerMl);
        OfferServiceImpl os = new OfferServiceImpl();
        os.updateOffer(offer);
    }
}
