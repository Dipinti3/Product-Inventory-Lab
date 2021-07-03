package models;

import junit.framework.TestCase;
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


}