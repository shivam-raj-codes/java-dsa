package com.shivam.hashmaps.questions;

import java.util.HashSet;

public class CountDistinctElement {
    static int distinct(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : arr) {
            set.add(i);
        }

        System.out.println("Distinct Elements are: " + set);

        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 6, 6, 7};
        System.out.println("No. of distinct element in array: " + distinct(arr));
    }
}
