package com.shivam.practice.PracticeProblems;

public class SecondMax {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int ans = s_Max(arr);
        System.out.println(ans);
    }

    public static int s_Max(int[] arr) {
        int max = arr[0];
        int sMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                sMax = max;      //🌟
                max = arr[i];
            }
            else if (arr[i] > sMax && arr[i] < max) {
                sMax = arr[i];
            }

        }
        return sMax;
    }

}
