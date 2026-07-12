package com.shivam.heaps.questions;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>(); // key -> element & value -> index

        for (int index = 0; index < nums.length; index++) {
            int rem = target - nums[index];

            if (map.containsKey(rem)) {
                //  is we found remaining in HashMap => we have elements pair that sum is equal to -> target
                // rem -> rem is an Array element, So give me it's index
                // give me the current element -> index?
                return new int[] {map.get(rem), index};
            }

            map.put(nums[index], index);
        }

        // as we don't found target
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
