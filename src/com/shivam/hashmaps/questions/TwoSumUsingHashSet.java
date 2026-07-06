package com.shivam.hashmaps.questions;

import java.util.HashSet;

public class TwoSumUsingHashSet {
    static boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele : arr) {
            int remaining = target - ele;

            if (set.contains(remaining)) { // set has ele = remain needed ele => got Target
                return true;
            }

            set.add(ele); // otherwise keep adding
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 7, 11, 15, 6, 3};

        boolean result = twoSum(arr, 20);

        System.out.println(result);
    }
}
