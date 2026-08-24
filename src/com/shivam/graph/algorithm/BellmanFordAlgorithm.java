package com.shivam.graph.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

// https://takeuforward.org/plus/dsa/problems/bellman-ford-algorithm
public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int s) {

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[s] = 0; // dist[src] = 0;

        // relaxation : V - 1 times
        for (int i = 0; i < V; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                // relaxation
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth relaxation to check negative-Cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            // relaxation done for Nth - iteration => Negative Cycle Exist => return array with -1.
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                return new int[] {-1};
            }
        }

        return dist;
    }
}
