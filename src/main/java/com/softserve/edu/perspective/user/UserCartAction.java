package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.entity.User;
import com.softserve.edu.service.CartService;
import com.softserve.edu.service.SaleService;
import com.softserve.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class UserCartAction {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    private List<Sale> allSalesInCart;
    private Cart userCart = new Cart();
    private User user = new User();

    public UserCartAction() {
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
        cartService.updateCart(userCart);
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

    public void setUserAndCart(Principal principal){
        String name = principal.getName();
        user = userService.findByUsername(name);
        userCart = cartService.getCartByUser(user);
    }


}
