package com.shivam.hashmaps.questions;

import java.util.HashMap;

public class ArraySubset {
    static boolean isSubSet(int[] a, int[] b) {
        // a[] = [11, 1, 13, 21, 3, 7, 3], b[] = [11, 3, 7, 1, 7]
        HashMap<Integer, Integer> aMap = new HashMap<>();

        for (int ele : a) {
            if (aMap.containsKey(ele)) {
                int freq = aMap.get(ele);

                aMap.put(ele, freq + 1);
            }
            else {
                aMap.put(ele, 1);
            }
        }

        HashMap<Integer, Integer> bMap = new HashMap<>();

        for (int ele : b) {

            /// b's element is not in array a => Not a Subset.
            if (!aMap.containsKey(ele)) {
                return false;
            }

            if (bMap.containsKey(ele)) {
                int freq = aMap.get(ele);

                bMap.put(ele, freq + 1);
            }
            else {
                bMap.put(ele, 1);
            }
        }

        for (int ele : bMap.keySet()) {
            int bFreq = bMap.get(ele); /// getting freq of elem in Map - b
            int aFreq = aMap.get(ele); /// getting freq of elem in Map - a

            if (aFreq < bFreq) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {11, 1, 13, 21, 3, 7, 3};
        int[]b = {11, 3, 7, 1, 7};

        System.out.println(isSubSet(a, b));
    }
}
