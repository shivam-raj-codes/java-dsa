package com.shivam.problems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];

            if (map.containsKey(remain)) {
                return new int[] {map.get(remain), i};
            }

            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
}
