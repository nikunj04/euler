package com.raval.euler.problems;

import java.util.ArrayList;
import java.util.List;
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
        List<Long> primes = new ArrayList<>();
        int maxSize=10001;
        long counter = 2;
        while(primes.size()<maxSize){
            if(isPrime(counter)){
                primes.add(counter);
            }
            counter++;
        }
        System.out.println(primes.get(maxSize-1));
    }

    static boolean isPrime(long number) {
        if(number ==2 || number == 3) return true;
        Long sqrRoot = new Double(number / Math.sqrt(number)).longValue();

        for (long l = 2; l <= sqrRoot; l++) {
            if (number % l == 0) {
                return false;
            }
        }
        return true;
    }
}
