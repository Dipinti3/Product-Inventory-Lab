package services;
import junit.framework.TestCase;
import models.Sneaker;
import org.junit.Assert;
import org.junit.Test;

public class SneakerServiceTest  {
    @Test
    public void createTest(){
        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        float expectedSize = 10.5f;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (2)
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty, expectedPrice);

        // (3)
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        double actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQty();
        float actualPrice = testSneaker.getPrice();
        // (4)

        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedSport, actualSport);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void findSneakerTest(){
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create("GoForIt", "Biba", "Hockey",
                54.8f, 54, 68.07f);
        Object expected = null;
        Object expected2 = testSneaker;
        Object actual = sneakerService.findSneaker(7);
        Object actual2 = sneakerService.findSneaker(1);

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void findAllSneakerTest(){
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create("CasualWear", "Bata", "Kabaddi",
                7.5f, 18, 900.12f);
        Sneaker testSneaker2 = sneakerService.create("KeepRunning", "Kbrand", "RelayRace",
                8.0f, 20, 365.08f);

        Sneaker[] expected = {testSneaker, testSneaker2};

        Sneaker[] actual = sneakerService.findAll();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteSneakerTest(){
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create("CasualWear", "Bata", "Kabaddi",
                20.5f, 12, 400.12f);
        Sneaker testSneaker2 = sneakerService.create("KeepRunning", "Kbrand", "RelayRace",
                5.0f, 200, 199.99f);

        Boolean expected = true;
        Boolean expected2 = false;

        Boolean actual = sneakerService.delete(9);
        Boolean actual2 = sneakerService.delete(5);

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

}