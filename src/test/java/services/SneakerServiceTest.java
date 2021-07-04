package services;

import junit.framework.TestCase;
import models.Sneaker;
import org.junit.Assert;
import org.junit.Test;

public class SneakerServiceTest  {
@Test
    public void createTest(){
    //given
    
    String expectedName = "Stan Smith";
    String expectedBrand = "Adidas";
    String expectedSport = "Tennis";
    float expectedSize = 10.5f;
    int expectedQty = 10;
    float expectedPrice = 80.00f;
    //when

    SneakerService sneakerService = new SneakerService();
    Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,
            expectedSport, expectedSize, expectedQty, expectedPrice);
    int actualId = testSneaker.getId();
    String actualName = testSneaker.getName();
    String actualBrand = testSneaker.getBrand();
    String actualSport = testSneaker.getSport();
    float actualSize = testSneaker.getSize();
    int actualQty = testSneaker.getQuantity();
    float actualPrice = testSneaker.getPrice();

    //then
    Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
    Assert.assertEquals(expectedName, actualName);
    Assert.assertEquals(expectedBrand, actualBrand);
    Assert.assertEquals(expectedSport, actualSport);
    Assert.assertEquals(expectedSize, actualSize,0.0);
    Assert.assertEquals(expectedQty, actualQty);
    Assert.assertEquals(expectedPrice, actualPrice,0.0);
}
}

