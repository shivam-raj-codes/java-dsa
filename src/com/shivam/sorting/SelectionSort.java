package com.shivam.recursion.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionSort(arr, 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int c, int r, int max ) {
        if (r == 0){  // when only one element left => arr is Sorted
            return;
        }

        if(c < r){

            if(arr[c] > arr[max]) {
                selectionSort(arr, c + 1, r, c);  // if current Idx. Element is Greater → update max
            }
            else {
                selectionSort(arr, c + 1, r , max ); //  Otherwise → Old max carry forward
            }
        }

        else {  //  This runs after c > r, i.e. scanning finished
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp; // arr[r-1] => last_index
            selectionSort(arr, 0 , r - 1, 0); //recursive - call after Largest, Sec. Largest so on! respectively already at Last_index.
        }

    }
}
