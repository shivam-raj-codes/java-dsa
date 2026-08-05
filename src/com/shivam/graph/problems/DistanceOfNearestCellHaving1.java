package com.shivam.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    class Pair {
        int first, second, steps;

        public Pair(int first, int second, int steps) {
            this.first = first;
            this.second =second;
            this.steps = steps;
        }
    }
    public int[][] nearest (int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int[][] distance = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    /// start bfs
                    q.offer(new Pair(i, j,0));

                    visited[i][j] = true; // marks as visited
                }
                else {
                   visited[i][j] = false;
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().steps;

            q.remove(); /// remove from Q

            distance[row][col] = steps; /// update distance Matrix

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                /// check Neighbours
                if (nRow >= 0 && nRow < n  && nCol >= 0 && nCol < m
                        && !visited[nRow][nCol]) {
                    ///  ive visited U
                    visited[nRow][nCol] = true;

                    /// Q, take this new Guy by increasing steps & keep it in queue
                    q.offer(new Pair(nRow, nCol, steps + 1));
                }
            }

        }
        return distance;
    }
}


// Time : O(n * m)

// space: O(n * m)
