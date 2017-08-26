package com.raval.euler.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 What is the 10 001st prime number?
 */

/**
 * Created by nikunj on 25/08/17.
 */
public class Solution7 {
    public static void main(String[] args) {
        System.out.println(
                Stream.iterate(2L , number1 -> number1 + 1L)
                .filter(Utility::isPrime)
                .limit(10001)
                .mapToLong(value -> value)
                .max());
    }


}
