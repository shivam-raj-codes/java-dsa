package com.shivam.practice.PracticeProblems;

import java.util.Arrays;
import java.util.Stack;

public class WarmTemperature {
    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = wTemperature(temp);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] wTemperature (int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] t = new int[temp.length];

        for (int i = temp.length - 1; i >= 0 ; i--) { // traversing Right to Left
            while (!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                t[i] = 0;
            } else {
                t[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return t;
    }
}
