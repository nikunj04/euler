package com.raval.euler.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *
 The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 Find the sum of all the primes below two million.

 */

/**
 * Created by nikunj on 25/08/17.
 */
public class Solution10 {
    public static void main(String[] args) {
        List<Long> primes = new ArrayList<>();
        int maxNumber=2000000;
        long counter = 2;
        long lastPrime = 0;
        while(lastPrime<maxNumber){
            if(isPrime(counter)){
                primes.add(counter);
                lastPrime=counter;
            }
            counter++;
        }
        System.out.println(primes.stream().filter(aLong -> aLong < maxNumber).mapToLong(value -> value).sum());

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
