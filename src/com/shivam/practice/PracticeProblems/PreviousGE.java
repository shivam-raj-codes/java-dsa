package com.shivam.practice.PracticeProblems;

import java.util.ArrayList;
import java.util.Stack;

public class PreviousGE {
    public static void main(String[] args) {
        int[] arr = {7, 4, 6, 1, 5, 2, 3};
        ArrayList<Integer> ans = previousGE(arr);
        //System.out.println(Arrays.toString(ans)); ? Why Giving Error
        System.out.println(ans);
    }

    public static ArrayList<Integer> previousGE(int[] arr) {
        Stack<Integer> stack = new Stack<>(); // storing index
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                list.add(-1);
            } else { // if peek is greater than current => ans
                list.add(arr[stack.peek()]);
            }

            stack.push(i);  // push
        }
        return list;
    }
}
