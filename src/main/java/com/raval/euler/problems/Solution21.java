package com.raval.euler.problems;

/**
 * Created by nikunj on 29/08/17.
 */

import java.util.stream.Stream;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Solution21 {

    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        Long sumOfAmicableNumber =
                Stream.iterate(2L, l -> l + 1)
                        .limit(10000)
                        .filter(solution::isAmicableNumber)
                        .mapToLong(value -> value)
                        .sum();

        System.out.println(sumOfAmicableNumber);
    }

    Long getSumOfDivisors(Long number) {
        return Utility.findFactor(number).stream()
                .filter(d -> d < number)
                .mapToLong(value -> value)
                .sum();
    }

    Boolean isAmicableNumber(Long number) {
        Long sumOfDivisors = getSumOfDivisors(number);
        Long sumOfDivisors1 = getSumOfDivisors(sumOfDivisors);
        return number.equals(sumOfDivisors1) && !number.equals(sumOfDivisors);
    }

}
