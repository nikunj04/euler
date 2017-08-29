package com.raval.euler.problems;

import java.util.stream.IntStream;

/**
 * Created by nikunj on 29/08/17.
 */
public class Solution28 {
    public static void main(String[] args) {
        Solution28 solution = new Solution28();
        System.out.println(solution.computeSum(1001));
    }

    Integer applyEquation(Integer n) {
        return (4 * n * n) - (6 * n) + 6;
    }

    Integer computeSum(Integer n) {
        return IntStream.iterate(3, i -> i + 2)
                .limit(n / 2)
                .map(this::applyEquation)
                .sum() + 1;
    }
}
