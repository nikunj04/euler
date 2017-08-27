package com.raval.euler.problems;

/**
 * Created by nikunj on 25/08/17.
 */

import java.util.stream.Stream;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Solution5 {


    public static void main(String[] args) {
        System.out.println(
                Stream.iterate(20L, aLong -> aLong - 1)
                        .limit(20)
                        .reduce(1L, (answer, i) -> answer * i / Utility.findGCF(i, answer))
        );
    }


}
