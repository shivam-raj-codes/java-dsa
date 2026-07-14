package com.shivam.hashmaps.questions;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
//    public static boolean containsDuplicate(int[] nums) {
//        // if any elem of array occur at least twice => true
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int element : nums) {
//            map.put(element, map.getOrDefault( element, 0) + 1);
//        }
//
//        for (int freq : map.values()) {
//            if (freq >= 2) {
//                return true;
//            }
//        }
//        return false;
//    }


    //=========== without forming a complete HashMap => Using HashSet. ==========

    public static boolean containsDuplicate(int[] nums) {

        // As HashSet only contains unique element
        HashSet <Integer> set = new HashSet<>();

        for(int element : nums) {

            if(!set.add(element)) {
                return true;     // hits the duplicates.
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 0, 0};
        System.out.println(containsDuplicate(nums));
    }
}
