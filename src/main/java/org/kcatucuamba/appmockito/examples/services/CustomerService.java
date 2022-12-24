package org.kcatucuamba.appmockito.examples.services;

public class CustomerService {

    public static boolean isPremium(String code){
        if (code.startsWith("1") && code.endsWith("0") && code.contains("JACK")){
            return true;
        }
        throw new RuntimeException("Invalid code");
    }

}
