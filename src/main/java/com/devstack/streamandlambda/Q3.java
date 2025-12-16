package com.devstack.streamandlambda;

import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        //make list names into uppercase
        List<String> names = Arrays.asList("Chalani","Moneesha","Thameera");
        System.out.println(names);
//        System.out.println(names.stream().map(x->x.toUpperCase()).toList());
        System.out.println(names.stream().map(String::toUpperCase).toList());
    }
}
