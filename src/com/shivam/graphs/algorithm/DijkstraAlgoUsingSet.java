package com.shivam.graphs.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class DijkstraAlgoUsingSet {
    static class Pair {
        int distance, node;
        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
    public ArrayList<Integer> dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        final int INF = (int) 1e9; /// Infinity

        TreeSet<Pair> set = new TreeSet<>(
                (x, y) -> x.distance == y.distance
                        ? Integer.compare(x.node, y.node)
                        : Integer.compare(x.distance, y.distance)
        ); /// Tree-set

        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        set.add(new Pair(0, src));
        dist[src] = 0;

        /// set traversal
        while (!set.isEmpty()) {
            Pair it = set.pollFirst();

            int node = it.node;
            int distance = it.distance;

            /// neighbour
            for (ArrayList<Integer> neighbour : adj.get(node)) {
                int adjNode = neighbour.get(0);
                int edgeW = neighbour.get(1);

                if (distance + edgeW < dist[adjNode]) {
                    /// need to erase if it existed & have any value other than (1e9)
                    if (dist[adjNode] != INF) {
                        set.remove(new Pair(dist[adjNode], adjNode));
                    }

                    dist[adjNode] = distance + edgeW; /// update distance
                    set.add(new Pair(dist[adjNode], adjNode)); /// add in Set
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : dist) {
            ans.add(i);
        }
        return ans;
    }
}

/// TreeSet Dijkstra:
/// Time  → O((V + E) log V)
/// Space → O(V + E)
// not much time saving but on bigger input can be efficient enough than Priority Queue.