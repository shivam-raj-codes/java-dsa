package com.shivam.heaps.questions;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElementInArray {

    static ArrayList<Integer> kLargest(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Integer> mh = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            mh.offer(arr[i]);

            if (mh.size() > k) {
                mh.poll();
            }
        }

        while (!mh.isEmpty()) {
            ans.add(mh.poll());
        }

        return ans; // list
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kLargest(arr, 3));
    }
}
