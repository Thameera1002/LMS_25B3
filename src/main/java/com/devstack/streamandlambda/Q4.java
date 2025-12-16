package com.devstack.streamandlambda;

import java.util.Arrays;
import java.util.List;

public class Q4 {
    public static void main(String[] args) {
        //print names one by one
        List<String> names = Arrays.asList("Chalani","Moneesha","Thameera");
        System.out.println(names);
        names.forEach(System.out::println);
    }
}
