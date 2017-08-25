package com.raval.euler.problems;

/**
 * Created by nikunj on 25/08/17.
 */

import java.util.stream.LongStream;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(findLargestPrime(600851475143L));
    }

    static Long findLargestPrime(Long number) {
        Long sqrRoot = new Double(number / Math.sqrt(number)).longValue();

        return LongStream.range(2, sqrRoot)
                .filter(l -> number % l == 0)
                .filter(l -> isPrime(l))
                .max().orElse(number);
    }

    static boolean isPrime(long number) {
        Long sqrRoot = new Double(number / Math.sqrt(number)).longValue();

        for (long l = 2; l <= sqrRoot; l++) {
            if (number % l == 0) {
                return false;
            }
        }
        return true;
    }
}
