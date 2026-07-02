package com.shivam.practice.PracticeProblems;

public class Print1toNanDViceVersa {
    public static void main(String[] args) {
        int n = 5;
        print1(n); // 1 to N
        print2(n); // N to 1
    }
    public static void print1(int n) {
        if (n == 0) {
            return;
        }
        print1(n -1); // first going deeper
        System.out.print(n +"  "); // then printing
    }

    public static void print2(int n) {
        if (n == 0) return;

        System.out.print(n + " "); // first printing
        print2(n - 1); // then going deeper
    }
}
