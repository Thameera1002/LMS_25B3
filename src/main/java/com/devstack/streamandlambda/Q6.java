package com.devstack.streamandlambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {
        //print ^2 number of the list give below using stream and lambda
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().map(x->x*x).toList());
    }
}
