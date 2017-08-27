package com.raval.euler.problems;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by nikunj on 26/08/17.
 */
public class Solution16 {
    static final BigInteger TWO = new BigInteger("2");
    static BigInteger get2raiseTo(int raiseTo){
        if(raiseTo == 1){
            return TWO;
        }
        else{
            BigInteger preCompute = get2raiseTo(raiseTo/2);
            return raiseTo % 2 ==0 ? preCompute.multiply(preCompute) : preCompute.multiply(preCompute).multiply(TWO);
        }

    }

    public static void main(String[] args) {

        Function<String, Long> functionToParseLine =
                str -> Stream.iterate(0, i -> i+1)
                        .limit(str.length())
                        .map(str::charAt)
                        .map(c -> Character.toString(c))
                        .mapToLong(Long::parseLong)
                        .sum();

        System.out.println(functionToParseLine.apply(get2raiseTo(1000).toString()));
    }
}
