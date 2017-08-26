package com.raval.euler.problems;

import java.util.List;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * Created by nikunj on 26/08/17.
 */
public class Solution14 {
    static class Tuple{
        Long seed;
        Long length;

        public Tuple(Long seed, Long length) {
            this.seed = seed;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "seed=" + seed +
                    ", length=" + length +
                    '}';
        }
    }
    static Tuple getSeqTerms(Long intial) {
        long current = intial;
        Long size = 1L;
        while (current != 1) {
            current = current % 2 == 0 ? current / 2 : (3 * current) + 1;
            size++;
        }
        return new Tuple(intial, size);
    }


    public static void main(String[] args) {
        System.out.println(LongStream.range(1, 1000000)
                .mapToObj(i -> Solution14.getSeqTerms(i))
                .max((o1, o2) -> o1.length > o2.length ? 1:-1).orElse(new Tuple(-1L, -1L)));
    }

}
