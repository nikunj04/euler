package com.raval.euler.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by nikunj on 28/08/17.
 */

public class Solution35 {
    Long limit = 1000000L;

    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        Set<Long> primes = new TreeSet<>(solution.getPrimes());
        Set<Long> circularPrimes = new TreeSet<>(solution.getCircularPrimes(primes));

        System.out.println("Primes ***   " + primes);
        System.out.println("Circular Primes ***   " + circularPrimes);
        System.out.println("Circular Primes ***   " + circularPrimes.size());

    }

    Set<Long> getCircularNumber(Long _number) {
        Long number = _number;
        Long base = base(number);
        Set<Long> returnSet = new HashSet<>();
        do {
            number = ((number % 10) * base) + (number / 10L);
            if (number > base) returnSet.add(number);
        } while (!number.equals(_number));
        return returnSet;
    }

    Set<Long> getPrimes() {
        Set<Long> primes = new HashSet<>();
        for (long i = 2L; i < limit; i++) {
            if (Utility.isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    Set<Long> getCircularPrimes(Set<Long> primes) {
        Set<Long> returnSet = new HashSet<>();
        for (Long prime : primes) {
            if (returnSet.contains(prime)) continue;
            Set<Long> circularCombinations = getCircularNumber(prime);
            if (primes.containsAll(circularCombinations)) returnSet.addAll(circularCombinations);
        }
        return returnSet;

        /*return primes
                .stream()
                .filter(prime -> primes.containsAll(getCircularNumber(prime)))
                .collect(Collectors.toSet());*/
    }

    Long base(Long number) {
        Long base = 1L;
        while (number > base) {
            base = base * 10;
        }
        return base / 10;
    }

}
