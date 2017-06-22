package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.service.CartService;
import com.softserve.edu.service.SaleService;

import java.util.ArrayList;
import java.util.List;

public class UserCartAction {
    private final Cart userCart;
    private List<Sale> allSalesInCart;
    private CartService cartService = new CartService();

    public UserCartAction() {
        userCart = new Cart();
        allSalesInCart = new ArrayList<Sale>();
        userCart.setSales(allSalesInCart);

        cartService.addCart(userCart);
    }


    public Sale addToCart(Offer offer, String volumeOrdered) {
        Sale sale = new Sale();
        sale.setOffer(offer);
        int volume = Integer.parseInt(volumeOrdered);
        sale.setVolumeOrdered(volume);
        sale.setCart(userCart);
        SaleService saleService = new SaleService();
        saleService.addSale(sale);
        userCart.addSaleToCart(sale);
        return sale;
    }

    public List<Sale> showCartContent() {

        SaleService saleService = new SaleService();

        List<Sale> currentSalesList = userCart.getSales();
        System.out.println("-------------------------------------------------" +
                "\nID\t\tPerfume\t\t Brand\t\t Price per ml \t Volume " +
                "Bought\n" +
                "-------------------------------------------------");
        for (Sale s : currentSalesList) {
            System.out.print(s.getId() + "\t" + s.getOffer().getPerfume()
                    .getName() + "\t " + s
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
        sale.getCart().removeSale(sale);
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

    public Cart getUserCart() {
        return userCart;
    }

    public List<Sale> getAllSalesInCart() {
        return allSalesInCart;
    }
    //    public int countSingleSalePrice(Sale s) {
//        int priceMl = s.getOffer().getPricePerMl();
//        int volumeOrdered = s.getVolumeOrdered();
//        return priceMl * volumeOrdered;
//    }

}
