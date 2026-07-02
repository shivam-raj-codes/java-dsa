package com.shivam.practice;

public class MaximumConsecutiveOneInArray {

    public static int consecutiveOne (int[] arr) {
        int count = 0;
        int max = 0;
        for (int i : arr) {

            if (i == 1) {
                count += 1;

                max = Math.max(max, count);
            }
            else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 9, 1, 1, 1};
        int ans = consecutiveOne(arr);
        System.out.println(ans);
    }
}
