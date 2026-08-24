package com.shivam.graphs.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ShortestPathInWeiUniDirectedGraph {
    static class Pair {
        int distance, node;
        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.distance, y.distance));

        int[] dist = new int[V];
        int[] parent = new int[V];

        /// initially filling array.
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        dist[src] = 0; /// src - node dist = 0

        pq.add(new Pair(0, src)); /// add src in PQ

        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.node;
            int dis = it.distance;

            if (dis > dist[node]) {
                continue;
            }

            for (Pair nei : adj.get(node)) {
                int adjNode = nei.node; /// neighbour node
                int edW = nei.distance; /// neighbour node - distance

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode)); /// add in Q

                    parent[adjNode] = node; /// parent - node of adjNode is -> node itself.
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();

        /// checking whether the destination is unreachable.
        if (dist[dest] == (int) 1e9) {
            path.add(-1);
            return path;
        }

        ///  find path
        int node = dest; // dest - node
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];  /// node please go back to where u came in from.
        }
        path.add(src); /// path please add 1st guy

        Collections.reverse(path);
        return path;
    }
}

///  Time: O(E logV + N).
