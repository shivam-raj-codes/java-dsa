package com.shivam.heaps.questions;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortAkSortedArray {

    static ArrayList<Integer> sort(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        ///  min-Heap cause want in Ascending - order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int element : arr) {
            minHeap.offer(element);

            if (minHeap.size() > k) {
                int correctPositionEle = minHeap.poll(); /// Not possible as I know heap won't be empty, Or we can use remove(); that throw exception on heap-empty
                list.add(correctPositionEle);
            }
        }
        while (!minHeap.isEmpty()) {
            list.add(minHeap.poll());
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};

        System.out.println(sort(arr, 3));
    }
}
