package com.shivam.practice.PracticeProblems;

import java.util.Scanner;
import java.util.Stack;

public class TS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack <Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(17);
        stack.push(71);
        if (!stack.isEmpty() && stack.pop() == 71) {
            System.out.println(stack.pop()); // 17
            System.out.println(stack.peek()); // 7
        }
    }
}
