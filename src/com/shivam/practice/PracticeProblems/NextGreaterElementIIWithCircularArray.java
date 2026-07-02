package com.shivam.practice.PracticeProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIIWithCircularArray {
    public static void main(String[] args) {
        int[] nums = {2, 10, 12, 1, 11};
        int[] ans = circularNGE(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] circularNGE (int[] nums) {
        Stack<Integer> stack = new Stack<>();  // will push index into Stack

        int n =  nums.length;
        int[] rArray = new int[nums.length];    // newArray of Same size
        Arrays.fill(rArray, -1); // 🌟 Already filled -1 if Any element have no Greater No need to fill manual -1


        for (int i = (2 * n) - 1; i >= 0 ; i--) { // r -> l (circularly => 2n - times

            int index = (i % n);

            while (!stack.isEmpty() && nums[stack.peek()] <= nums[index]) { // pop till peek - ele is lesser or equal to current
                stack.pop();
            }

            if (i < n && !stack.isEmpty()){ // fill only when we have build stack when at the hypothetical Circular array and At actual array
                    rArray[index] = nums[stack.peek()];
            }

            // push
            stack.push(index);

        }
        return rArray;
    }
}
