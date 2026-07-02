package com.shivam.practice.PracticeProblems;


import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75};
        int[] span = stockSpan(prices);
        System.out.println(Arrays.toString(span));
    }

    public static int[] stockSpan(int[] prices) {
        Stack<Integer> stack = new Stack<>(); // stores idx
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            // pop until previous <= current
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();  // pop till we not get price greater than current price
            }

            // calculate span
            if (stack.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - stack.peek(); // current price idx - previous {nearest greater element idx}. (this way we are finding distance between current and previous greater price
            }

            // push current idx
            stack.push(i);
        }

        return ans;
    }
}