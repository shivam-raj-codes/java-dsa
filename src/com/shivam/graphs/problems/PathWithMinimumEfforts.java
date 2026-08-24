package com.shivam.graphs.problems;
// You are given a 2D array mat[][], of size n*m. Your task is to find the minimum possible path cost from
// the top-left cell (0, 0) to the bottom-right cell (n-1, m-1) by moving up, down, left, or right between adjacent cells.
//Note: The cost of a path is defined as the maximum absolute difference between the values of any two consecutive cells along that path.

import java.util.PriorityQueue;

public class PathWithMinimumEfforts {
    // we are using Dijkstra

    static class Pair {
        int first, second, third;

        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int minCostPath(int[][] mat) {

        // {diff, row, col}
        PriorityQueue<Pair> pq = new PriorityQueue<>(((x, y) -> Integer.compare(x.first, y.first))); /// min-heap

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        int[] delR = {-1, 0, +1, 0};
        int[] delC = {0, +1, 0, -1};
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int diff = p.first;
            int r = p.second;
            int c = p.third;

            /// ans: destination check.
            if (r == n - 1 && c == m - 1) {
                return diff;
            }

            // Try all four neighboring cells.
            for (int i = 0; i < 4; i++) {
                int nR = r + delR[i];
                int nC = c + delC[i];

                /// validity check
                if (nR >= 0 && nR < n && nC >= 0 && nC < m) {

                    /// Height difference between current cell and neighbor.
                    int heightDiff = Math.abs(mat[r][c] - mat[nR][nC]);

                    /// max(current effort, new height difference)
                    int newEffort = Math.max(diff, heightDiff);

                    // If reaching this cell with newEffort is better
                    // than the previously known effort, update it.
                    if (newEffort < dist[nR][nC]) {

                        /// Hey dist[], we found a better way to reach
                        /// (nR, nC)!
                        dist[nR][nC] = newEffort;

                        pq.offer(new Pair(newEffort, nR, nC));
                    }
                }
            }
        }
        return 0; /// unreachable.
    }
}

// Time: O(E logV) => E -> n x m x 4 x & V-> log(n x m)
// V -> no. of nodes

// Space: O(n x m).

