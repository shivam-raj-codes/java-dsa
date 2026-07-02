package com.shivam.practice.PracticeProblems;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String str = "(){[]";
        boolean result = isValid(str);
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '[') { // for open push
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) { // if stack is empty and we hit closing brackets
                    return false;
                }

                char top = stack.peek();
                // better to use not equal and when not equal return false inside below if - statement
                if (ch == ')' && top == '(' || ch == '}' && top == '{'|| ch == ']' && top == '[') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
