package com.devstack.streamandlambda;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        //print the even numbers of the list give below using stream and lambda
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,45,83,78,33);
        System.out.println(numbers);
        System.out.println(numbers.stream().filter(x->x%2==0).toList());
    }
}
