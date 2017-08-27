package com.raval.euler.problems;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nikunj on 26/08/17.
 */
public class Utility {

    static Set<Long> findFactor(long number) {
        long half = new Double(number / Math.sqrt(number)).longValue();
        Set<Long> factors = new HashSet<>();
        factors.add(1L);
        for (long i = 1; i <= half; i++) {
            if (number % i == 0) {
                factors.add(i);
                factors.add(number / i);
            }
        }
        return factors;
    }

    static boolean isPrime(long number) {
        return findFactor(number).size() <= 2 ? true : false;
    }

    static Long findGCF(long number1, long number2) {
        Set<Long> factor1 = findFactor(number1);
        Set<Long> factor2 = findFactor(number2);
        factor1.retainAll(factor2);
        long max = 1L;
        for (Long value : factor1) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    static <T> List<T> readFile(String strResource, Function<String, T> function) throws Exception {
        Path resource = Paths.get(ClassLoader.getSystemResource(strResource).toURI());
        List<List<T>> returnList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(resource)) {
            return lines.map(function::apply)
                    .collect(Collectors.toList());
        }
    }
}
