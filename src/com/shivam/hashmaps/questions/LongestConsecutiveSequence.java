package com.shivam.hashmaps.questions;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int ele : nums) {  /// => O(n)
            set.add(ele);
        }

        int longest = 0;
        /// Iterate over HashSet instead of the array.
        /// HashSet stores only unique elements, so duplicate numbers are processed only once
        /// HashSet order doesn't matter because we don't rely on traversal order.
        /// We generate the sequence ourselves using current++ and only use the set for O(1) lookups.
        for (int num : set) {  /// => O(n)

            if (set.contains(num - 1)) {
                // skip => for this iteration everything below inside for-loop not execute
                continue;
            }

            int count = 0;
            int current = num; // this is start of sequence & while - loop start

            while (set.contains(current)) {
                /// Count the sequence
                count++;
                current++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 8, 9, 10, 5, 0, -1};
        System.out.println(longestConsecutive(arr));
    }

}
