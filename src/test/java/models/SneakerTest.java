package models;

import org.junit.Assert;
import org.junit.Test;

public class SneakerTest {
    @Test
    public void setNameTest(){
        //given
        String expected="OZWEEGO";
        //when
        Sneaker testSneaker=new Sneaker();
        testSneaker.setName(expected);
        //then
        Assert.assertEquals(expected,testSneaker.getName());
    }

    @Test
    public void testParameterizedConstructor(){
        //given

        //when
        int expectedId=6;

        String expectedName="Stan Smith";
        String expectedBrand="Adidas";
        String expectedSport="Tennis";
        int expectedQuantity=10;
        float expectedPrice=80.00f;
        Sneaker sweetAdidas = new Sneaker(expectedId,expectedName, expectedBrand,
                expectedSport, expectedQuantity, expectedPrice);
        //then
        Assert.assertEquals(expectedId,sweetAdidas.getId());
        Assert.assertEquals(expectedName,sweetAdidas.getName());
        Assert.assertEquals(expectedBrand,sweetAdidas.getBrand());
        Assert.assertEquals(expectedSport,sweetAdidas.getSport());
        Assert.assertEquals(expectedQuantity,sweetAdidas.getQuantity());
        Assert.assertEquals(expectedPrice,sweetAdidas.getPrice(),0.0);
    }


}