package com.shivam.practice;
import java.lang.String;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String st = ")(";
        boolean result = isValid(st);
        System.out.println(result);
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                // when closing bracket hit that time if Top of stack there is not the open - bracket => Not valid para
                if (ch == ')' && stack.peek() != '(') {
                    return false;
                }
                else if (ch == '}' && stack.peek() != '{') {
                    return false;
                }
                else if(ch == ']' && stack.peek() != '[') {
                    return false;
                }
                stack.pop(); // when closing - bracket hit if at top there is same open brackets => pop that open one
            }
        }
        return stack.empty(); // if stack is Empty means Valid
    }

}
