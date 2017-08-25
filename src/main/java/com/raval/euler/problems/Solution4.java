package com.raval.euler.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikunj on 25/08/17.
 */


/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Solution4 {

    static final long BASEOF=10L;

    static Boolean isPalindromic(Long number){
        List<Long> breakNumber = breakNumber(number);
        for(int i=0; i < Math.ceil(breakNumber.size()/2.0) ;i++){
            if(breakNumber.get(i) != breakNumber.get(breakNumber.size() -1 - i))
                return false;
        }
        return true;
    }

    static List<Long> breakNumber(Long number){
        List<Long> numbers = new ArrayList<>();

        long base = BASEOF;
        while(number > base)
            base = base * BASEOF;
        base = base / BASEOF;
        while(base > 1)
        {
            numbers.add(number/base);
            number = number % base;
            base = base / BASEOF;
        }
        numbers.add(number);
        return numbers;
    }

    public static void main(String[] args) {
        long multiple1 = 999L;
        long multiple2 = 999L;

        long number = multiple1 * multiple2;
        List<long[]> palindromes = new ArrayList<>();
        while(multiple1>99){

            if(multiple2 > 99){
                multiple2--;
            }else{
                multiple2 = 999L;
                multiple1--;
            }
            if(isPalindromic(number)){
                palindromes.add(new long[]{number, multiple1, multiple2});
                System.out.println(multiple1+" * "+multiple2+" = "+number);
            }

            number = multiple1 * multiple2;
        }
        long max=Long.MIN_VALUE;
        long[] result=null;
        for(long[] palindrome: palindromes){
            if(palindrome[0] > max)
            {
                max = palindrome [0];
                result = palindrome;
            }
        }
        System.out.println(result[0] + "=" + result[1] + "*"+result[2]);
    }
}
