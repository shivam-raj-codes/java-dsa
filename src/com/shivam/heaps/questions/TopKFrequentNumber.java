package com.shivam.heaps.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentNumber {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<Integer> topKFreqNum(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        /// HashMap
        HashMap<Integer, Integer> map = new HashMap<>(); /// key = ele & value =frequency

        // int freq = 1;
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1); // map.get(num) -> givers value at key(num)
            }
            else  {
               // map.put(num, freq);
                map.put(num, 1); // if its 1st Occurrence of 'num' => frequency = 1.
            }
        }

        /// MIN - Heap
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.second - b.second);

        /// iterate over Map
        for (int num : map.keySet()) {
            int frequent = map.get(num);

            minHeap.offer(new Pair(num, frequent));

            if (minHeap.size() > k) { /// goes above > k => first remove
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            list.add(p.first);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 4};
        int k = 2;

        System.out.println(topKFreqNum(arr, k));
    }
}
