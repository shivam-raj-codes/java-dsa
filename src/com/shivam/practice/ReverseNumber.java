package com.shivam.practice;

public class ReverseNumber {

    public static int reverse(int n) {
        if (n < 10) {
            return n;
        }

        int digits = (int) Math.log10(n) + 1;
        int last_digit = n % 10;

        return last_digit * (int) Math.pow(10, digits - 1) + reverse(n / 10);
    }

    public static void main(String[] args) {
        int n = 1234;
        System.out.println("Original Number: " + n);
        int result = reverse(n);
        System.out.print("Reversed Number: " + result);
    }
}
