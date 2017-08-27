package com.raval.euler.problems;

import java.util.stream.LongStream;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 * <p>
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * <p>
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

/**
 * Created by nikunj on 25/08/17.
 */
public class Solution6 {

    public static void main(String[] args) {
        int limit = 100;
        Long sum = LongStream.range(1L, limit)
                .reduce((aLong, aLong2) -> aLong + aLong2)
                .orElse(0L);
        Long squareOfSum = sum * sum;
        System.out.println(squareOfSum);

        Long sumOfSquare =
                LongStream.range(1L, limit)
                        .map(aLong -> aLong * aLong)
                        .reduce((aLong, aLong2) -> aLong + aLong2)
                        .orElse(0L);
        System.out.println(sumOfSquare);
        System.out.println(squareOfSum - sumOfSquare);
    }
}
