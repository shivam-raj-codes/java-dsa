package com.shivam.practice;

public class MoveZeroToEnd {

    public static void moveZero(int[] arr) {

        // two - pointer approach
        int i = 0;
        int j = i + 1;

        while (j != arr.length) {
            if (arr[i] == 0 && arr[j] == 0) { // when both point to Zero move j -> only
                j = j + 1;
            }
            else if (arr[i] == 0 && arr[j] !=0 ) { // i at Zero and j at Non - Zero swap both so zero come at last
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j = j + 1;
                i = i + 1;
            }
            else {  // both are at non-zero
                i = i + 1;
                j = j + 1;
            }
        }

        System.out.println("Resultant Array");
        for(int k : arr) {
            System.out.print(k + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 3, 7, 0};

        System.out.println("Original Array");
        for(int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();

        moveZero(arr);
    }

}
