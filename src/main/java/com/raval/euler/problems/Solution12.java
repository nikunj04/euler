package com.raval.euler.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by nikunj on 26/08/17.
 */
public class Solution12 {

    static Map<Long, Long> triangularMap = new HashMap<>();

    static class Information{
        Long index;
        Long value;
        Set<Long> factors;

        public Information(Long index) {
            this.index = index;
            this.value = findTriangularNumber(index);
            this.factors = findFactor(value);
        }

        @Override
        public String toString() {
            return "Information{" +
                    "index=" + index +
                    ", value=" + value +
                    ", factors.size " + factors.size() +
                    ", factors=" + factors +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(
        Stream.iterate(1L, aLong -> aLong+1)
                .limit(15000)
                .map(Information::new)
                .filter(information -> information.factors.size()>500)
                .map(information -> information.value)
                .findFirst()
                .orElse(Long.MIN_VALUE));
    }

    static Long findTriangularNumber(long limit){
        if(triangularMap.containsKey(limit-1)){
            triangularMap.put(limit, triangularMap.get(limit-1)+limit);
            return triangularMap.get(limit);
        }
        return Stream.iterate(1L, aLong -> aLong+1)
                .limit(limit)
                .mapToLong(value -> value)
                .sum();
    }

    static Set<Long> findFactor(long number){
        long half = new Double(number / Math.sqrt(number)).longValue();
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
