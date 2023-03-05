package org.kcatucuamba.appmockito.examples.services;

public class CustomerService {

    public static boolean isPremium(String code){
        if (code.startsWith("1") && code.endsWith("0") && code.contains("JACK")){
            return true;
        }
        throw new RuntimeException("Invalid code");
    }

    public static String dayMessage(Integer value){
        if (value == 1){
            return "Monday";
        }
        if (value == 2){
            return "Tuesday";
        }
        if (value == 3){
            return "Wednesday";
        }
        if (value == 4){
            return "Thursday";
        }
        if (value == 5){
            return "Friday";
        }
        if (value == 6){
            return "Saturday";
        }
        if (value == 7){
            return "Sunday";
        }
        throw new RuntimeException("Invalid day");
    }

}
