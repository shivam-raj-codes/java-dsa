package com.shivam.revision;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int target = 8;
        System.out.println(search(arr, target, 0, arr.length - 1));
    }

    public static int search(int[] arr, int target, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;

            if(arr[m] == target) {
                return m;
            }

            // which half is sorted
            if(arr[s] <= arr[m]) {
                /// left is sorted

                // is target lies in left ?
                if(target >= arr[s] && target < arr[m]) {
                    /// it is
                    e = m -1;
                }

                else {
                    /// it's not
                    s = m + 1;
                }

            }
            else {
                /// right is sorted

                // is target lies in left ?
                if (target > arr[m] && target <= arr[e]) {
                    /// it is
                    s = m + 1;
                } else {
                    /// it's not
                    e = m - 1;
                }
            }
        }
        return -1;
    }
}

