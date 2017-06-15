package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.service.CartService;
import com.softserve.edu.service.SaleService;

import java.util.List;

public class UserCartAction {
    private Cart userCart = new Cart();

    public void addToCart(Offer offer, String volumeOrdered){
        Sale sale = new Sale();
        sale.setOffer(offer);
        int volume = Integer.parseInt(volumeOrdered);
        sale.setVolumeOrdered(volume);
        SaleService saleService = new SaleService();
        saleService.addSale(sale);
        userCart.addSaleToCart(sale);
        CartService cartService = new CartService();
        cartService.addCart(userCart);

    }

    public void showCartContent(){

        SaleService saleService = new SaleService();
            List<Sale> currentSalesList = saleService.getAllSales();
            System.out.println("-------------------------------------------------" +
                    "\nPerfume\t\t Brand\t\t Price per ml \t Volume Bought\n" +
                    "-------------------------------------------------");
            for (Sale s: currentSalesList) {
                System.out.print(s.getOffer().getPerfume().getName() + "\t " + s.getOffer().getPerfume().getBrand().getName() + "\t " +
                        s.getOffer().getPricePerMl() +"\t\t "+ s.getVolumeOrdered()+"\n");
            }

    }

    public void order(){

    }

    public void deletefromCart(Sale sale){

    }

    public void countTotalPrice(){

    }
}
