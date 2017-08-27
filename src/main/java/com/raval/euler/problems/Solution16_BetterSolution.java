package com.raval.euler.problems;

import org.apache.commons.lang.StringUtils;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by nikunj on 27/08/17.
 */
public class Solution16_BetterSolution {

    String sum(String value1, String value2) {
        value1 = removeLeadingZeros(value1);
        value2 = removeLeadingZeros(value2);
        int maxSize = Integer.max(value1.length(), value2.length()) + 1;
        final char[] valueA = StringUtils.leftPad(value1, maxSize, "0").toCharArray();
        final char[] valueB = StringUtils.leftPad(value2, maxSize, "0").toCharArray();
        final char[] result = new char[maxSize];

        int carry = 0;
        for (int i = maxSize - 1; i >= 0; i--) {
            int sum = carry + Character.getNumericValue(valueA[i]) + Character.getNumericValue(valueB[i]);
            carry = sum / 10;
            result[i] = Character.forDigit(sum % 10, 10);
        }
        return removeLeadingZeros(new String(result));
    }

    String removeLeadingZeros(String str){
        return str.replaceFirst("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        Solution16_BetterSolution solution16BetterSolution = new Solution16_BetterSolution();
        String value="1";
        for(int i=1;i<1001;i++){
            value = solution16BetterSolution.sum(value, value);
            System.out.println(i+"   " + value);
        }

        Function<String, Long> functionToParseLine =
                str -> Stream.iterate(0, i -> i+1)
                        .limit(str.length())
                        .map(str::charAt)
                        .map(c -> Character.toString(c))
                        .mapToLong(Long::parseLong)
                        .sum();
        System.out.println(functionToParseLine.apply(value));
    }
}
