package com.shivam.graphs.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// https://takeuforward.org/plus/dsa/problems/number-of-ways-to-arrive-at-destination
public class NoOfWaysToArriveAtDestination {

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // adj index represents the source/current vertex.
        // Each Pair inside the list stores: (adjacent vertex, edge weight).
        // For an undirected edge {u, v, w}, add:
        // u -> (v, w) and v -> (u, w).
        for (int[] g : roads) {
            adj.get(g[0]).add(new Pair(g[1], g[2]));
            adj.get(g[1]).add(new Pair(g[0], g[2]));
        }

        // {dist, node}
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.first, y.first));
        int[] dist = new int[n];
        int[] ways = new int[n];

        Arrays.fill(dist, (int) 1e9);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0)); // dist, node

        int mod = (int)(1e9 + 7);

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int dis = p.first;
            int node = p.second;

            // adj - list
            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                // this is first time I am arriving
                // with this short distance
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;

                    pq.offer(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node]; // in order to reach the adjacency I came via Node so equals to ways[Node].
                }
                // we are having same path as the shortest already arrive
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {
        int[][] roads = {
                {0, 1, 2},
                {1, 2, 3},
                {0, 3, 5},
                {1, 3, 3},
                {2, 3, 4}
        };
        int n = 4;

        System.out.println(countPaths(n, roads));
    }
}


// In adjacency list:
//
//adj.get(g[0])
//
//the source vertex itself is represented by the index.