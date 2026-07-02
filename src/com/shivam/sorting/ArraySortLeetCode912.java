package com.shivam.recursion.Sorting;


import java.util.Arrays;

//Given an array of integers nums, sort the array in ascending order and return it.
//You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
public class ArraySortLeetCode912 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 6};
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int s, int e) {

        // base - case -> Because range size is what reduces, not array length.
//        “if sub - array contain only one element,
//        so, that is already sorted,
//                recursion immediately stop.”
        if (e - s == 1) {
            return;
        }


        int m = s + (e - s) / 2;
        sort(arr, s, m); // sort - left part of array
        sort(arr, m, e); // sort - right part of array

        // To merge both sorted halves

        merge(arr, s, m, e);
    }

    static void merge(int[] arr, int s, int m, int e){
        int [] mix = new int[e - s]; // temporary array which store mix of both sorted halves

        int i = s; // pointing for left
        int j = m;   // pointing for right
        int k = 0;     // pointing for mix

        while (i < m && j < e) {
            if (arr[i] < arr[j]){
                mix[k] = arr[i]; // mix - array having element in sorted order
                i = i + 1;
            }
            else {
                mix[k] = arr[j];
                j = j + 1;
            }
            k = k + 1;
        }

        // for element still remaining to merge of any one of sub - part
        while (i < m){
            mix[k] = arr[i];
            i = i + 1;
            k = k + 1;
        }

        while (j < e){
            mix[k] = arr[j];
            j = j + 1;
            k = k + 1;
        }

        // // place sorted elements from mix[] back into the Original Array starting at index 's'
        for (int l = 0; l < mix.length; l ++ ){
            arr[s + l] = mix[l];
        }

    }


}

     /*  flow & execution of for - loop , with s = any starting index you want.
      suppose s = 3
        first iteration arr[3+0] = mix[0]
        second iteration arr[3+1] = mix[1]
        arr[3+1] means in original array at index 4, put what is at index 1 of mix
        and so on
        because s is passed to the merge function

✔ All of this is correct

*/