package com.shivam.practice.PracticeProblems;

public class ZeroesCount {
    public static void main(String[] args) {
        int n = 12003040;
        int ans = countZeroes(n);
        System.out.println(ans);
    }

    public static int countZeroes(int n) {
        if (n == 0) return 1;
        return helper(n, 0);
    }
    public static int helper(int n, int count) {
        // base - case
        if (n == 0) return count; // count needs to pass future fn call so pass it in an Argument.

        // at a time only one recursive - call going to happen
        if (n % 10 == 0) { // if digit is zero
            return helper(n / 10, count + 1);
        }

        return helper(n / 10, count);

    }
}
