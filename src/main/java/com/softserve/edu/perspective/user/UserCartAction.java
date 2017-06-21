package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.service.CartService;
import com.softserve.edu.service.SaleService;

import java.util.ArrayList;
import java.util.List;

public class UserCartAction {
    private Cart userCart = new Cart();
    private List<Sale> allSalesInCart;


    public Sale addToCart(Offer offer, String volumeOrdered) {
        Sale sale = new Sale();
        sale.setOffer(offer);
        int volume = isVolumeValid(offer,volumeOrdered);
        sale.setVolumeOrdered(volume);
        SaleService saleService = new SaleService();
        saleService.addSale(sale);
        userCart.addSaleToCart(sale);
        CartService cartService = new CartService();
        cartService.addCart(userCart);
        return sale;
    }

    public List<Sale> showCartContent() {

        SaleService saleService = new SaleService();
        List<Sale> currentSalesList = saleService.getAllSales();
        System.out.println("-------------------------------------------------" +
                "\nID\t\tPerfume\t\t Brand\t\t Price per ml \t Volume Bought\n" +
                "-------------------------------------------------");
        for (Sale s : currentSalesList) {
            System.out.print(s.getId()+"\t"+s.getOffer().getPerfume().getName() + "\t " + s
                    .getOffer().getPerfume().getBrand().getName() + "\t " +
                    s.getOffer().getPricePerMl() + "\t\t " + s
                    .getVolumeOrdered() + "\n");
        }
        return currentSalesList;

    }

    public List<Sale> orderSalesFromCart() {
        allSalesInCart = userCart.getSales();
        for (Sale sale : allSalesInCart) {
            UserOrder userOrder = new UserOrder();
            userOrder.decreaseOfferVolumeBySale(sale);
        }
        return allSalesInCart;
    }

    public void deletefromCart(Sale sale) {
        SaleService saleService = new SaleService();
        saleService.deleteSale(sale);

    }

    public int countTotalPrice() {
        allSalesInCart = userCart.getSales();
        int totalPrice = 0;
        for (Sale s : allSalesInCart) {
            int priceMl = s.getOffer().getPricePerMl();
            int volumeOrdered = s.getVolumeOrdered();
            totalPrice += (priceMl * volumeOrdered);
        }
        return totalPrice;
    }

    private int isVolumeValid(Offer offer, String volume){
        int volumeInt=0;
        if(!volume.matches("[1-9]\\d*")){
            throw new IllegalArgumentException("Please, enter the whole positive numbers only");
        }
        volumeInt=Integer.valueOf(volume);
        if(volumeInt>offer.getVolumeForSale()){
            throw new IllegalArgumentException("This offer has " + offer.getVolumeForSale()+" ml left");

        }

        return volumeInt;
    }

//    public int countSingleSalePrice(Sale s) {
//        int priceMl = s.getOffer().getPricePerMl();
//        int volumeOrdered = s.getVolumeOrdered();
//        return priceMl * volumeOrdered;
//    }

}
