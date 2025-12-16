package com.devstack.streamandlambda;

import java.util.Arrays;
import java.util.List;

public class Q7 {
    public static void main(String[] args) {
        //get the maximum number from this list using stream and lambda
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().max(Integer::compareTo).get());
    }
}
