package com.shivam.questions;

public class ReverseANumber {
    public static void main(String[] args) {
        int n = 1234;
        int result = revNum(n);
        System.out.println("Reverse of " + n + " is: "  + result);
    }
    public static int revNum(int n) {
        if (n < 10) {
            return n;
        }

        int digits = (int) Math.log10(n) + 1;
        int l_digit = (n % 10);

        return (l_digit * (int) Math.pow(10, digits - 1)) + revNum(n / 10);
    }
}
