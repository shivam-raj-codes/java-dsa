package com.shivam.heaps.questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumOfElementsBetweenK1AndK2Smallest {

    public static int sumBetweenK1AndK2Smallest(int[] arr, int k1, int k2) {
        int start = kSmallest(arr, Math.min(k1, k2)); /// start
        int end = kSmallest(arr, Math.max(k1, k2)); /// end

        int sum = 0;

        for(int element : arr) {
            if (element > start && element < end ) { // in range (start, end)
                sum += element;
            }
        }

        return sum;
    }

    public static int kSmallest(int[] arr, int k) {
        ///  max - heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {

            maxHeap.offer(num);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }

        }

        return !maxHeap.isEmpty() ? maxHeap.peek() : -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 5, 15, 11};
        System.out.println(sumBetweenK1AndK2Smallest(arr, 3, 6));
    }
}
