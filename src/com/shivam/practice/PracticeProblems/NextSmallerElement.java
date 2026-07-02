package com.shivam.practice.PracticeProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        int[] result = nextSmaller(arr);
        System.out.println(Arrays.toString(result));
    }
    public static int[] nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>(); // stores index
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) { // pop till peek is Greater or equal to current
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1; // if empty => ans = -1
            }
            else if (arr[stack.peek()] < arr[i]) { // if peek is smaller than current => ans
                ans[i] = arr[stack.peek()];
            }

            stack.push(i);
        }
        return ans;
    }
}
