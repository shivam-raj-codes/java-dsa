package com.shivam.practice;

public class palindromeCheck {

    public static boolean isPalindrome(int n) {

        if (n >= 0 && n < 10) {
            return true;
        }

        int digits = (int) Math.log10(n) + 1;

        int f_digit = n / (int) Math.pow(10, digits - 1);

        int l_digit = n % 10;

        if (f_digit != l_digit) {
            return false;
        }

        return isPalindrome((n % (int) Math.pow(10, digits - 1)) / 10); // trimmed from both right side and left
    }

    public static void main(String[] args) {
        int n = 12;
        boolean ans = isPalindrome(n);
        System.out.println(ans);
    }
}
