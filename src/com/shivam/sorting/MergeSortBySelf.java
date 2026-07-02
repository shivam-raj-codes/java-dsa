package com.shivam.recursion.Sorting;
import java.util.Arrays;
public class MergeSortBySelf {
    public static void main(String[] args) {
        int[] nums ={9, 8, 12, 2, 7};
        mergeSort(nums, 0, nums.length); // end = arr.length not length - 1. Since, i'm excluding last idx
        System.out.println(Arrays.toString(nums)); // as only Change made in original array so printing original array itself.
    }

    static void mergeSort(int[] arr, int start, int end) {
        if ((end - start) == 1) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid); // for left - part
        mergeSort(arr, mid, end);  // for right - part

        // merging both halves part
        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {
       int[] temp = new int[end - start]; // temporary

        int i = start; // iterator for left - part & pointing to start idx
        int j = mid;  // iterator for right - part & pointing to mid idx
        int k = 0;  // iterator for temp - array

        // loop - for comparison
        while (i < mid && j < end){
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i += 1;
            }
            else if (arr[j] < arr[i]) {
                temp[k] = arr[j];
                j += 1;
            }
            k += 1;
        }

        // final updated value of i and j by comparison - loop will be used in below while - loop to copy remaining. i and j = final updated value by above while - loop.
        while (i < mid) { // adding remaining element from left - part
            temp[k] = arr[i];
            i += 1;
            k +=1;
        }

        while (j < end) {
            temp[k] = arr[j];
            j += 1;
            k += 1;
        }

        // making changes in Original array as temp - containing sorted array

        for (int l = 0; l < temp.length; l++){
            arr[start + l] = temp[l];
        }


    }
}
