package com.softserve.edu.perspective.user;

//@Component
public class UserOrder {
//    private ServiceFactory serviceFactory= new ServiceFactory();
//    private SubmittedOrderService submittedOrderService;
//    private SaleService saleService;
//    private UserCartAction userCartAction;
//    private UserService userService;
//    private CartService cartService;
//    private OfferService offerService;
//
//    @Autowired
//    public UserOrder(ServiceFactory serviceFactory, UserCartAction userCartAction) {
//        this.submittedOrderService=serviceFactory.getSubmittedOrderService();
//        this.saleService=serviceFactory.getSaleService();
//        this.userService=serviceFactory.getUserService();
//        this.cartService=serviceFactory.getCartService();
//        this.userCartAction=userCartAction;
//        this.offerService=serviceFactory.getOfferService();
//
//    }
//
//
//    public void decreaseOfferVolumeBySale(Sale sale) {
//        Offer offer = sale.getOffer();
//        String updateVol;
//        int volumeOffer = offer.getVolumeForSale();
//        int volumeBought = sale.getVolumeOrdered();
//        int updateOfferVolume = volumeOffer - volumeBought;
//        if (volumeBought > volumeOffer) {
//            System.out.println("Sorry, but we have only " + volumeOffer + " " +
//                    "ml left.");
//            updateOfferVolume = volumeOffer;
//        }
//        offer.setVolumeForSale(String.valueOf(updateOfferVolume));
//        offerService.updateOffer(offer);
//    }
//
//    public void order(Cart cart) {
//        SubmittedOrder newOrder = new SubmittedOrder();
//        User user = cart.getUser();
//
//
//        int price = userCartAction.countTotalPrice();
//        List<Sale> salesToSubmit = new ArrayList<>(cart.getSales());
//
//        newOrder.setUser(user);
//        newOrder.setTotalPrice(price);
//
//
//        newOrder.setSales(salesToSubmit);
//        submittedOrderService.addSubmittedOrder(newOrder);
//
////        submittedOrderService.updateSubmittedOrder(newOrder);
//        user.addOrder(newOrder);
//        userService.updateUser(user);
//        salesTransfer(cart, newOrder);
//        userService.updateUser(user);
//
//    }
//
//    public void salesTransfer(Cart cart, SubmittedOrder newOrder) {
//        List<Sale> salesToSubmit = cart.getSales();
//        Iterator<Sale> iterator = salesToSubmit.iterator();
//        while (iterator.hasNext()) {
//            Sale s = iterator.next();
//            s.setSubmittedOrders(newOrder);
//            s.setCart(null);
//            saleService.updateSale(s);
//            decreaseOfferVolumeBySale(s);
//        }
//        submittedOrderService.updateSubmittedOrder(newOrder);
//        cartService.updateCart(cart);
//    }


}
