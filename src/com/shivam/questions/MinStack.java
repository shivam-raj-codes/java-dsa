package com.shivam.questions;


import java.util.Stack;

public class MinStack {

    Stack<Integer> mainstack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        mainstack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public int pop() {
        int popped = mainstack.pop();
        if (popped == minStack.peek()) {
            minStack.pop();
        }
        return popped;
    }

    public int top() {
        return mainstack.peek();
    }

    public int getMin() {
        return minStack.peek(); // as minStack storing minimum element
    }

    public static void main(String[] args) {

        MinStack op = new MinStack();
        op.push(7);
        op.push(9);
        op.push(3);
        op.push(8);
        op.push(2);

        System.out.println(op.getMin());

    }
}
