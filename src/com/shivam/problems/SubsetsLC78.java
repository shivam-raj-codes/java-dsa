package com.shivam.problems;

import java.util.ArrayList;
import java.util.List;

public class SubsetsLC78 {

    public static List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> resultSet = new ArrayList<>();

       backtrack(nums, resultSet, new ArrayList<>(), 0);

       return resultSet;
    }

    public static void backtrack(int[] nums, List<List<Integer>> resultSet, List<Integer> temList, int index) {
        if (index == nums.length) {
            System.out.println(temList);
            resultSet.add(new ArrayList<>(temList)); // make copy of tempList & add in resultSet.
            return;
        }

        /// take it
        temList.add(nums[index]);
        backtrack(nums, resultSet, temList, index + 1);


        // All these calls receive a reference to the same ArrayList object: => back-tracking needed.
        // so we must undo our choice before exploring the skip branch.
        /// back-track.
        temList.remove(temList.size() - 1);

        /// skip it => without including current index into tempList increase the index i.e; index + 1.
        backtrack(nums, resultSet, temList, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
