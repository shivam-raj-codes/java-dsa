package com.shivam.hashmaps.questions;

public class SubarraySumEqualsK {
    // A subarray is a contiguous non-empty sequence of elements within an array.

    public static int subarraySum(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0; // every new starting index i should begin with a fresh sum.

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subarraySum(arr, 3));
    }
}
