package com.shivam.problems;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    public static int helper(int[] arr, int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            ///  After checking mid, remove mid from the next search range.
            // left half sorted
            if (arr[s] <= arr[mid]) {
                if (target >= arr[s] && target <= arr[mid]) {
                    // search in left
                    e = mid - 1;
                }
                else {
                    // search in right
                    s = mid + 1;
                }
            }
            else {
                // right half is sorted
                if (target >= arr[mid] && target <= arr[e]) {
                    // search in right
                    s = mid + 1;
                }
                else {
                    // search in left
                    e = mid - 1;
                }
            }
        }

        return  -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }
}
