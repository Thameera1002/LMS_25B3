package com.devstack.streamandlambda;

import java.util.Arrays;
import java.util.List;

public class Q5 {
    public static void main(String[] args) {
        //fetch the name from list which is starts with M
        List<String> names = Arrays.asList("Chalani","Moneesha","Thameera");
        System.out.println(names.stream().filter(s->s.startsWith("M")).toList());
    }
}
