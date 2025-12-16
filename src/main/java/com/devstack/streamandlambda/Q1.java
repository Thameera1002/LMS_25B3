package com.devstack.streamandlambda;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        //print below list into reverse order
        List<String> names = Arrays.asList("Chalani","Moneesha","Thameera");
        System.out.println(names);
        Collections.reverse(names);
        System.out.println(names);
    }

}
