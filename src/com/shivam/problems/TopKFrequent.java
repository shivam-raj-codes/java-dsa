package com.shivam.problems;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {


    public static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    // [1,2,1,2,1,2,3,1,3,2], k = 2 : o/p -> [1, 2].
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        ///  calculate frequency.
        for (int ele : nums) {
            if (map.containsKey(ele)) {
                int frq = map.get(ele);
                map.put(ele, frq + 1);
            }
            else {
                map.put(ele, 1);
            }
        }


        // minHeap
        PriorityQueue<Pair> minH = new PriorityQueue<>( (x, y) -> Integer.compare(x.second, y.second) );

        // iterate over Map on keySet()
        for (int num : map.keySet()) {

            int frq = map.get(num);

            // index & ele.
            minH.offer(new Pair(num, frq));

            if (minH.size() > 2) {
                minH.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (!minH.isEmpty()) {
            Pair p = minH.poll();
            int ele = p.first;

            ans[i++] = ele;
        }

        return ans;
    }
}
