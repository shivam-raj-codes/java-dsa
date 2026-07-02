package com.shivam.practice;

public class ReverseArrayInPlace {

    // in - place
    public static void reverse(int[] arr) {
        // two - pointer
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            // swap - do inPlace reverse
            int temp = arr[s]; // 🌟 stores value at s - idx not idx
            arr[s] = arr[e];
            arr[e] = temp;

            s = s + 1; // one step ahead
            e = e - 1; // one step back
        }

        System.out.println("\nReversed Array");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7};

        System.out.println("Original Array");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // method call
        reverse(arr);
    }
}
