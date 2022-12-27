package org.kcatucuamba.appmockito.examples.services.test;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kcatucuamba.appmockito.examples.services.CustomerService;

public class CustomerServiceTest {

    @Test
    public void testIsPremium(){
        CustomerService.isPremium("1JACK10");
        Assert.assertTrue(true);
    }


    @Test()
    public void testIsPremiumFail(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("xJACKx");
        });
    }

    @Test()
    public void testIsPremiumFail2(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("xcualqiu");
        });
    }

    @Test()
    public void testIsPremiumFail3(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("1xcualqiu0");
        });
    }

    @Test()
    public void testIsPremiumFail4(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("mJACKO");
        });
    }

    @Test()
    public void testIsPremiumFail5(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("1malo4");
        });
    }

    @Test()
    public void testIsPremiumFail56(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("xamalo0");
        });
    }

    @Test()
    public void testDayMessage(){
        String day = CustomerService.dayMessage(1);
        Assert.assertEquals("Monday", day);
    }

}
