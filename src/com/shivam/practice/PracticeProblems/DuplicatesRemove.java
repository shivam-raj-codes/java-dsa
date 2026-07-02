package com.shivam.practice.PracticeProblems;
import java.util.Stack;
public class DuplicatesRemove {
    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removingDuplicates(str));
    }
    public static String removingDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(ch);
            }
            else{
                if (ch == stack.peek()) {
                    stack.pop();
                }
                else {
                    stack.push(ch);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

//        1. reverse → fix order
//        2. toString → convert StringBuilder to String
//        3. return → give final answer
        return result.reverse().toString();
    }
}
