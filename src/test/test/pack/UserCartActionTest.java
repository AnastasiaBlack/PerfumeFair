package test.pack;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.service.OfferService;
import com.softserve.edu.service.ServiceFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class UserCartActionTest {

    @Mock
    private ServiceFactory serviceFactory;
    private UserCartAction userCartAction;
    @Mock
    private OfferService offerService;

    @Test
    public void testDecreaseOfferVolumeBySale_CorrectVolume() {
        //Arrange
        MockitoAnnotations.initMocks(this);
        userCartAction = new UserCartAction(serviceFactory);
        userCartAction.setOfferService(offerService);
        Offer offer = new Offer();
        offer.setVolumeForSale(40);
        Sale sale = new Sale();
        sale.setVolumeOrdered(12);
        sale.setOffer(offer);

        //Act
        Mockito.doNothing().when(offerService).updateOffer(offer);
        userCartAction.decreaseOfferVolumeBySale(sale);
        offer = sale.getOffer();
        Integer expectedVolumeLeft = 28;
        Integer actualVolumeLeft = offer.getVolumeForSale();
        //Assert
        Assert.assertEquals(expectedVolumeLeft, actualVolumeLeft);
    }

    @Test
    public void testDecreaseOfferVolumeBySale_VolumeIsTooBig() {
        //Arrange
        MockitoAnnotations.initMocks(this);
        userCartAction = new UserCartAction(serviceFactory);
        userCartAction.setOfferService(offerService);
        Offer offer = new Offer();
        offer.setVolumeForSale(40);
        Sale sale = new Sale();
        sale.setVolumeOrdered(50);
        sale.setOffer(offer);

        //Act
        Mockito.doNothing().when(offerService).updateOffer(offer);
        userCartAction.decreaseOfferVolumeBySale(sale);
        offer = sale.getOffer();
        Integer expectedVolumeLeft = 0;
        Integer actualVolumeLeft = offer.getVolumeForSale();
        //Assert
        Assert.assertEquals(expectedVolumeLeft, actualVolumeLeft);
    }

    @Test
    public void testCountTotalPrice() {
        //Arrange
        MockitoAnnotations.initMocks(this);
        userCartAction = new UserCartAction(serviceFactory);
        Offer offer1 = new Offer();
        offer1.setPricePerMl(10);
        Sale sale1 = new Sale();
        sale1.setOffer(offer1);
        sale1.setVolumeOrdered(10);
        Offer offer2 = new Offer();
        offer2.setPricePerMl(5);
        Sale sale2 = new Sale();
        sale2.setOffer(offer2);
        sale2.setVolumeOrdered(5);
        ArrayList<Sale> allSalesInCart = new ArrayList<>();
        allSalesInCart.add(sale1);
        allSalesInCart.add(sale2);
        Cart cart = new Cart();
        cart.setSales(allSalesInCart);
        UserCartAction.setUserCart(cart);

        //Act
        int actualPrice = userCartAction.countTotalPrice();
        int expectedPrice = 125;

        //Assert
        Assert.assertEquals(expectedPrice, actualPrice);
    }

}
