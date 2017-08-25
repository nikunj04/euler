package com.raval.euler.problems;

/**
 * Created by nikunj on 25/08/17.
 */

import org.apache.commons.lang.ArrayUtils;

import java.util.*;
import java.util.stream.LongStream;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Solution5 {


    public static void main(String[] args) {
        Set<Long> factorSet = new HashSet<>();

        long answer = 1;

        for(int i=20;i>0;i--){
            Set<Long> factorsForNumber = findFactor(i);
            Set<Long> factorsForAnswer = findFactor(answer);
            Long gcf = findGCF(factorsForAnswer, factorsForNumber);
            answer = answer * i / gcf;
        }

        System.out.println(answer);
    }

    static Long findGCF(Set<Long> factor1, Set<Long> factor2){
        factor1.retainAll(factor2);
        long max = 1L;
        for(Long value:factor1){
            if(value>max){
                max = value;
            }
        }
        return max;
    }

    static Set<Long> findFactor(long number){

        long half = new Double(number / 2).longValue();
        Set<Long> factors = new HashSet<>();
        factors.add(1L);
        for(long i=1;i<=half;i++){
            if(number%i == 0){
                factors.add(i);
                factors.add(number/i);
            }
        }
        return factors;
    }
}
