package com.shivam.practice;

public class ReverseStringArray {

    public static void rev(char[] ch) {
        int s = 0;
        int e = ch.length - 1;

        while (s < e) {
            // swap

            char temp = ch[s];
            ch[s] = ch[e];
            ch[e] = temp;

            s ++;
            e --;
        }

        System.out.println("Sorted Array");
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd'};

        System.out.println("\nArray");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        rev(arr);

    }
}
