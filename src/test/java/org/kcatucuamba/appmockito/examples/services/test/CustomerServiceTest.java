package org.kcatucuamba.appmockito.examples.services.test;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kcatucuamba.appmockito.examples.services.CustomerService;

class CustomerServiceTest {

    @Test
    void testIsPremium(){
        CustomerService.isPremium("1JACK10");
        Assert.assertTrue(true);
    }


    @Test()
    void testIsPremiumFail(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("xJACKx");
        });
    }

    @Test()
    void testIsPremiumFail2(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("xcualqiu");
        });
    }

    @Test()
    void testIsPremiumFail3(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("1xcualqiu0");
        });
    }

    @Test()
    void testIsPremiumFail4(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("mJACKO");
        });
    }

    @Test()
    void testIsPremiumFail5(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("1malo4");
        });
    }

    @Test()
    void testIsPremiumFail56(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            CustomerService.isPremium("xamalo0");
        });
    }

}
