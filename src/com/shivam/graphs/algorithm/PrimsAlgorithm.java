package com.shivam.graphs.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // return Sum of the weights of edges.
    public int spanningTree(int V, int[][] edges) {

        // adj. List
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            /// {node, wt}
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.weight, y.weight));

        int[] vis = new int[V];
        Arrays.fill(vis, 0);

        /// {node , edW}
        pq.offer(new Pair(0, 0));

        int sum = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int node = p.node;
            int wt = p.weight;

            if (vis[node] == 1) {
                /// already visited
                continue;
            }

            // only mark as visited, when we add it to MST.
            sum += wt; /// parts of MST
            vis[node] = 1; /// mark as visited

            // neighbours Stores as Pair in adj-List.
            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edW = it.weight;

                if (vis[adjNode] == 0) {
                    /// not visited => go in PQ & no need to mark as visited
                    pq.offer(new Pair(adjNode, edW));
                }
            }
        }
        return sum;
    }
}
