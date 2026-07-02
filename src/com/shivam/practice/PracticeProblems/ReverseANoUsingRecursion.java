package com.shivam.practice.PracticeProblems;

public class ReverseANoUsingRecursion {
    public static void main(String[] args) {
        int n = 12345;
        int digits = (int) Math.log10(n) + 1;  // gives me No. Of total digits (int n) have
        int reversedNum = reverse(n, digits);
        System.out.println(reversedNum);

    }

    public static int reverse(int n, int digits) {
        // base case
        if (n < 10) return n;

        return ((n % 10) * (int) Math.pow(10, digits - 1)) + reverse(n / 10, digits - 1);  // digits - 1 , beCoz digit after ignoring last digit
    }
}



//  int digit = (int) Math.log10(n) + 1; // to find Number of Digits

// Math.power(double a, double b) --> returns double !! Not integer so TypeCasting Needed