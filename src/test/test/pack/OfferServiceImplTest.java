package test.pack;

import com.softserve.edu.dao.OfferDAO;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.service.impl.OfferServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class OfferServiceImplTest {
    @Mock
    private OfferDAO offerDAO;

    @Test
    public void testGetAllOffers_ExpectedSortedByPrice() {
        //Arrange
        MockitoAnnotations.initMocks(this);
        OfferServiceImpl offerService = new OfferServiceImpl();
        offerService.setOfferDAO(offerDAO);

        List<Offer> offerListBeforeSort = new ArrayList<>();
        Offer offer1 = new Offer();
        offer1.setPricePerMl(12);
        Offer offer2 = new Offer();
        offer2.setPricePerMl(2);
        Offer offer3 = new Offer();
        offer3.setPricePerMl(18);
        Offer offer4 = new Offer();
        offer4.setPricePerMl(6);
        offerListBeforeSort.add(offer1);
        offerListBeforeSort.add(offer2);
        offerListBeforeSort.add(offer3);
        offerListBeforeSort.add(offer4);

        List<Offer> expectedList = new ArrayList<>();
        expectedList.add(offer2);
        expectedList.add(offer4);
        expectedList.add(offer1);
        expectedList.add(offer3);


        //Act
        Mockito.doReturn(offerListBeforeSort).when(offerDAO).getAllElements();
        List<Offer> actualList = offerService.getAllOffers();

        //Assert
        Assert.assertEquals(expectedList, actualList);
    }

}
