package com.shivam.practice.PracticeProblems.Pattern_PrintingRecursively;

public class IsPalindrome {
    public static void main(String[] args) {
        int n = 121;
        boolean result = isPalindrome(n);
        System.out.println(result);
    }

    public static boolean isPalindrome(int n) {
        if (n < 10) { // single - digit Always Recursion
            return true;
        }

        int digits = (int) Math.log10(n) + 1;

        int l_digit = n % 10;

        //int divisor = (int) Math.pow(10, digits - 1);

        int f_digit = n / (int) Math.pow(10, digits - 1);

        if (l_digit != f_digit) {
            return false;
        }

        return isPalindrome((n % (int) Math.pow(10, digits - 1) / 10)); // trim from last n first

    }
}
