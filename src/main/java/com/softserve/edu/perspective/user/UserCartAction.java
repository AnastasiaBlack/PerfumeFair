package com.softserve.edu.perspective.user;

import com.softserve.edu.entity.*;
import com.softserve.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserCartAction {
    private ServiceFactory serviceFactory = new ServiceFactory();
    private SubmittedOrderService submittedOrderService;
    private UserService userService;
    private OfferService offerService;
    private CartService cartService;
    private SaleService saleService;

    private List<Sale> allSalesInCart;
    private static Cart userCart = new Cart();
    private static User user = new User();

    @Autowired
    public UserCartAction(ServiceFactory serviceFactory) {
        this.userService = serviceFactory.getUserService();
        this.cartService = serviceFactory.getCartService();
        this.saleService = serviceFactory.getSaleService();
        this.submittedOrderService = serviceFactory.getSubmittedOrderService();
        this.offerService = serviceFactory.getOfferService();
    }


    @Transactional
    public void addToCart(int offerId, String volumeOrdered) {
        Offer offer = offerService.getOfferById(offerId);
        Sale sale = new Sale();
        sale.setOffer(offer);
        int volume = Integer.parseInt(volumeOrdered);
        sale.setVolumeOrdered(volume);
        sale.setCart(userCart);
        saleService.addSale(sale);
        userCart.addSaleToCart(sale);
        cartService.updateCart(userCart);
    }

    public List<Sale> showCartContent() {
        return userCart.getSales();
    }

    public List<Sale> orderSalesFromCart() {
        allSalesInCart = userCart.getSales();
        for (Sale sale : allSalesInCart) {
            decreaseOfferVolumeBySale(sale);
        }
        return allSalesInCart;
    }

    @Transactional
    public void deletefromCart(int saleId) {
        Sale sale = saleService.getSaleById(saleId);
        userCart.removeSale(sale);
        cartService.updateCart(userCart);
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

    public void setUserAndCart(Principal principal) {
        String name = principal.getName();
        user = userService.findByUsername(name);
        userCart = cartService.getCartByUser(user);
        userCart.setSales(saleService.getAllSalesFromCart(userCart));
    }

    public void decreaseOfferVolumeBySale(Sale sale) {
        Offer offer = sale.getOffer();
        String updateVol;
        int volumeOffer = offer.getVolumeForSale();
        int volumeBought = sale.getVolumeOrdered();
        int updateOfferVolume = volumeOffer - volumeBought;
        if (volumeBought > volumeOffer) {
            System.out.println("Sorry, but we have only " + volumeOffer + " " +
                    "ml left.");
            updateOfferVolume = volumeOffer;
        }
        offer.setVolumeForSale(String.valueOf(updateOfferVolume));
        offerService.updateOffer(offer);
    }

    @Transactional
    public void order(Cart cart) {
        SubmittedOrder newOrder = new SubmittedOrder();
        User user = cart.getUser();


        int price = countTotalPrice();
        List<Sale> salesToSubmit = new ArrayList<>(cart.getSales());

        newOrder.setUser(user);
        newOrder.setTotalPrice(price);


        newOrder.setSales(salesToSubmit);
        submittedOrderService.addSubmittedOrder(newOrder);

        user.addOrder(newOrder);
        salesTransfer(cart, newOrder);
        userService.updateUser(user);
        cart.getSales().clear();
        cartService.updateCart(cart);

    }

    public void salesTransfer(Cart cart, SubmittedOrder newOrder) {
        List<Sale> salesToSubmit = cart.getSales();
        Iterator<Sale> iterator = salesToSubmit.iterator();
        while (iterator.hasNext()) {
            Sale s = iterator.next();
            s.setSubmittedOrders(newOrder);
            s.setCart(null);
            saleService.updateSale(s);
            decreaseOfferVolumeBySale(s);
        }
        submittedOrderService.updateSubmittedOrder(newOrder);
        cartService.updateCart(cart);
    }

    //these are mostly needed while testing
    public static void setUserCart(Cart userCart) {
        UserCartAction.userCart = userCart;
    }

    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
}
