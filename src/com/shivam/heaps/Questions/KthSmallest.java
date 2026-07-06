package com.shivam.heaps.Questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {

    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);

            if (maxHeap.size() > k ) {
                maxHeap.poll(); // poll will remove the top - ele
            }
        }

        return maxHeap.peek(); // heap top-element is kth-smallest
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int result = kthSmallest(arr, k);
        System.out.println(result);
    }
}
