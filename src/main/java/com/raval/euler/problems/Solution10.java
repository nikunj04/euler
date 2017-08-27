package com.raval.euler.problems;

import java.util.stream.IntStream;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

/**
 * Created by nikunj on 25/08/17.
 */
public class Solution10 {
    static int TWO_MILLION = 2000000;

    public static void main(String[] args) {
        System.out.println(IntStream.range(2, TWO_MILLION)
                .filter(Utility::isPrime)
                .mapToLong(value -> value)
                .sum());
    }
}
