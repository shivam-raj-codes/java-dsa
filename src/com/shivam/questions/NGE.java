package com.shivam.questions;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10};
        int[] ans = nGE(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] nGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();  // store index
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >=0 ; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            }
            else if (arr[stack.peek()] > arr[i]) {
                ans[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return ans;
    }
}
