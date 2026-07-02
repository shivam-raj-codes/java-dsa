package com.shivam.practice.PracticeProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 18};
        int[] ans = NextGE(arr);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] NextGE (int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >=0 ; i--) { // right to left Traversal

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;  // Ans
            }
            else if (stack.peek() > arr[i]) {
                ans[i] = stack.peek();  // Ans
            }

            stack.push(arr[i]);
        }
        return ans;
    }
}

