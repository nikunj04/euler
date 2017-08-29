package com.raval.euler.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nikunj on 29/08/17.
 */
public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution = new Solution49();
        List<Integer> listPrime = solution.getPrimes();
        Set<Integer> setPrime = new HashSet<>(listPrime);


        for (int i = 0; i < listPrime.size(); i++) {
            int prime0 = listPrime.get(i);
            for (int j = i + 1; j < listPrime.size(); j++) {
                int prime1 = listPrime.get(j);
                int prime2 = prime1 + (prime1 - prime0);
                if (setPrime.contains(prime2)) {
                    Set<Integer> digit0 = solution.getDigits(prime0);
                    Set<Integer> digit1 = solution.getDigits(prime1);
                    if (digit0.equals(digit1) && digit0.equals(solution.getDigits(prime2)))
                        System.out.println("Found " + prime0 + " " + prime1 + " " + prime2);
                }
            }
        }
    }


    List<Integer> getPrimes() {
        return Stream.iterate(1000, l -> l + 1)
                .limit(9000)
                .filter(Utility::isPrime)
                .collect(Collectors.toList());

    }

    Set<Integer> getDigits(Integer _number) {
        Supplier<Integer> digitSupplier = new Supplier<Integer>() {
            Integer number = _number;

            @Override
            public Integer get() {

                Integer previousNumber = number;
                number = number / 10;
                return previousNumber;
            }
        };

        return Stream.generate(digitSupplier)
                .limit(4)
                .map(number -> number % 10)
                .collect(Collectors.toSet());

    }
}
