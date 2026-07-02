package com.shivam.practice.PracticeProblems;

public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) { // loop helps to put Non - Zero value at correct Position
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        for (int i = pos; i < nums.length; i++) { // filling zero from where 'pos' pointing till end of array
            nums[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }
}
