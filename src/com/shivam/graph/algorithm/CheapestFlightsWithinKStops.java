package com.shivam.graph.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    static class Edge {
        int first, second;

        Edge(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static class Pair {
        int first, second, third;

        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    // n = no. of cities => nodes
    public static int findCheapestCost(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
        }

        // {stops, node, distance}
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        /// Dijkstra doesn't directly work because the state depends on both cost + stops.
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int stops = p.first;
            int node = p.second;
            int cost = p.third;

            /// this path is invalid → skip it.
            if (stops > k) continue;

            // adjacent traverse on adjList with Pair => (Edge)
            for (Edge it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.offer(new Pair(stops + 1, adjNode, cost + edW));
                }
            }
        }

        if (dist[dst] == (int) 1e9) {
            // not reachable
            return -1;
        }
        return dist[dst];
    }
}

// No PriorityQueue => no O(log V) heap operation.
// We may process nodes for different numbers of stops.
// Time: O(K * E)
// Space: O(V + E)