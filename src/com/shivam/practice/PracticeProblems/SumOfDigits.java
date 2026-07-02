package com.shivam.practice.PracticeProblems;


public class SumOfDigits {
    public static void main(String[] args) {
        int n = 999999999;
        int total_Sum = cal_sumOfDigit (n);
        System.out.println(total_Sum);
    }
/*
    public static int cal_sumOfDigit(int n) {
        return helper(n, 0);
    }

    public static int helper(int n, int sum) {
        // base - case
        if (n == 0) {
            return sum;
        }

        return helper(n / 10, sum + (n % 10)); // extracting last digit and add with sum and reduce digit and pass to future fn call.


    }
*/

    public static int cal_sumOfDigit(int n) {
        // base case
        if (n == 0) {
            return 0;
        }

        return (n % 10) + cal_sumOfDigit(n / 10);  // I've sum of first digit rest Now, Hey recursive fun call remaining digit ke sum lake de.
    }

}



