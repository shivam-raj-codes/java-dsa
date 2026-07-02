package com.shivam.practice.PracticeProblems;

public class Count_Digits {
    public static void main(String[] args) {
        int n = 102;
        int ans = digits_count(n);
        System.out.println(ans);
    }
    public static int digits_count(int n) {
        return helper(n, 0);
    }

    public static int helper(int n, int count) {
        if (n == 0 && count == 0) return 1; // 0 is also a digit
        if (n == 0) {
            return count;
        }

        return helper(n / 10, count + 1);
    }
}
