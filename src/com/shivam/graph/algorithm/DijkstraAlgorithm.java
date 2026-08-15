package com.shivam.graph.algorithm;
import java.util.*;

public class DijkstraAlgorithm {

    static class Pair {
        int node, distance;
        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public ArrayList<Integer> dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.distance, y.distance));

        /// distance[].
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e9));

        dist[src] = 0;
        pq.offer(new Pair(0, src)); /// PQ will initially have.

        while (!pq.isEmpty()) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            /// smart - escape / stale-entry optimization.
            // If I already have a better distance to this node, there is no point in checking the neighbors using this old distance.
            if (distance > dist[node]) {
                continue;
            }

            /// iterate adjacent - Node
            for (ArrayList<Integer> it : adj.get(node)) {
                int edgeWeight = it.get(1); /// weight from 2nd place.
                int adjNode = it.get(0); /// node from 1st place.

                if (distance + edgeWeight < dist[adjNode]) {
                    /// got shorter distance.
                    dist[adjNode] = distance + edgeWeight; // update in dist[]
                    pq.add(new Pair(dist[adjNode], adjNode)); // add updated dist[adjNode] & adjNode in PQ.
                }
            }
        }

        /// dist[] -> ArrayList{}
        ArrayList<Integer> ans = new ArrayList<>();

        for (int d : dist) {
            ans.add(d);
        }

        return ans;
    }
}

/// Dijkstra + adjacency list + PriorityQueue
/// Time  → O((V + E) log V)
/// Space → O(V + E)
