package com.shivam.questions;

import java.util.Scanner;

public class CountingNumberOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int n = sc.nextInt();
        int result = digits_count(n);
        System.out.println(result);
    }

    static int digits_count(int n){
        int count = 0;
        while(n != 0){
            n /= 10;
            count ++;
        }
        return count;
    }
}
