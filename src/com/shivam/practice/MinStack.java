package com.shivam.practice;

import java.util.Stack;

public class MinStack {

    // defining inside class instead of constructor so that can available Globally
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        // initializing
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (mainStack.isEmpty()) {
            mainStack.push(val);
            minStack.push(val);
            return;
        }

        mainStack.push(val);

        if (val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            return -1;
        }

        int popped = mainStack.pop();

        if (popped == minStack.peek()) {
            minStack.pop();
        }
        return popped;
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack operation = new MinStack();
        operation.push(5);
        operation.push(18);
        operation.push(9);
        operation.push(13);
        operation.push(7);

        int min = operation.getMin();
        System.out.println(min);

        System.out.println(operation.top());
        System.out.println(operation.pop());
        System.out.println(operation.getMin());
    }
}
