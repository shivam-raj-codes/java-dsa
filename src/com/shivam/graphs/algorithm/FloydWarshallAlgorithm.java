package com.shivam.graphs.algorithm;

// https://takeuforward.org/plus/dsa/problems/floyd-warshall-algorithm
public class FloydWarshallAlgorithm {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /// no direct edge
                if (dist[i][j] == -1) {
                    dist[i][j] = (int) 1e9;
                }
                /// diagonals
                if (i == j) dist[i][j] = 0;
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        // for negative cycle
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Negative Cycle Exist");
            }
        }

        /// before returning ans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /// not reachable
                if (dist[i][j] == (int) 1e9) {
                    dist[i][j] = -1;
                }
            }
        }
    }
}

// Space: O(n^2)
// Time : O(n^3)
