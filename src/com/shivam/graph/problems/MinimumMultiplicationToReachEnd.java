package com.shivam.graph.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://takeuforward.org/plus/dsa/problems/minimum-multiplications-to-reach-end.
public class MinimumMultiplicationToReachEnd {

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;

        // {node, steps}
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[100000];
        Arrays.fill(dist, (int) 1e9);

        q.offer(new Pair(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.first;
            int steps = p.second;

            // Unweighted graph -> BFS traversal
            for (int it : arr) {
                int num = (it * node) % mod; /// will keep num value in range of {0, 10^5-1}

                if (steps + 1 < dist[num]) {
                    // we find better/shorter way to reach
                    dist[num] = steps + 1; /// dist[]

                    if (num == end) {
                        /// reached end
                        return steps + 1; /// ans
                    }

                    q.offer(new Pair(num, steps + 1));
                }
            }
        }
        return -1;
    }
}

// Time: O(100000 * N).
// Space: O(dist[] -> 100000 + Queue -> at most O(100,000) Pair objects).
