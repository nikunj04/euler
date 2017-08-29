package com.raval.euler.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nikunj on 29/08/17.
 */
public class Solution49 {
    public static void main(String[] args) {
        List<Long> primes1 = Stream.iterate(1486L, l -> l+1)
                .limit(9000L)
                .filter(Utility::isPrime)
                .collect(Collectors.toList());
        Set<Long> primes = new HashSet<>(primes1);
        Long primeInQuestion = -1L;
        Long nextPrime = -1L;
        for(int i=0;i<primes1.size();i++){
            primeInQuestion = primes1.get(i);
            for(int j=i+1;j<primes1.size();j++){
                nextPrime = primes1.get(j);
                if(primes1.contains(nextPrime) && primes1.contains(nextPrime + (nextPrime - primeInQuestion)))
                    System.out.println("Found "+ primeInQuestion + " "+nextPrime + " " + (nextPrime+(nextPrime - primeInQuestion)));
            }
        }
    }
}
