package com.shivam.graphs.problems;

//Given an Undirected Graph of N vertices from 0 to N-1 and M edges and a 2D Integer array edges,
//where there is an edge from vertex edges[i][0] to vertex edges[i][1] of unit weight.
//Find the shortest path from the source to all other nodes in this graph. In this problem statement,
//we have assumed the source vertex to be ‘0’. If a vertex is unreachable from the source node, then return -1 for that vertex.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/// N -> vertex.
/// M -> edge.
public class ShortestPathInUnDirGHavingUnitDistanceUsingBFS {
    public int[] shortestPath(int[][] edges, int N, int M, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // create graph => by processing Edge(M).
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[N]; /// dist- Array
        Arrays.fill(dist,(int) 1e9);

        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        /// standard bfs:
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();

            // all adj. neighbour Node
            for (int it: adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node];
                    q.offer(it);
                }
            }
        }

        /// for reachable node
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}

// Time: O(V + 2E).
