package com.shivam.practice.PracticeProblems.Pattern_PrintingRecursively;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 9};
        int result = sMax(arr);
        System.out.println(result);
    }

    public static int sMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int s_Max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                s_Max = max; // old Max become sMax
                max = i;  // as new Elem become MAx 👆
            }
            else if (i > s_Max && i < max) { // as if Elem is GreaterEqual than sMAx and also less, then max => that is SMax
                s_Max = i;
            }
            else if (s_Max == Integer.MIN_VALUE) {
                System.out.println("Second Largest not Exist");
                return - 1;
            }
        }
        return s_Max;
    }
}
