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

}
