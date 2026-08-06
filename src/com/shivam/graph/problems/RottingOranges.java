package com.shivam.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    static class Pair {
        int row, col, tm;

        public Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // {{r, c}, tm}
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) { ///  if it is rotting
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2; // mark as rotten
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int tm = 0;
        int[] dRow = {-1, 0, +1, 0};
        int[] dCol = {0, +1, 0, -1};
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm, t); /// take max time
            q.poll();

            ///  visit all neighbour
            for (int i = 0; i < 4; i++) {
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] != 2 && grid[nRow][nCol] == 1) {
                    q.add(new Pair(nRow, nCol, t + 1));
                    vis[nRow][nCol] = 2;
                }
            }
        }

        // check is all the fresh Oranges is Converted into rotten or not ?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] != 2 && grid[i][j] == 1) {
                    // fresh - Orange or Not converted in 2 => -1
                    return -1;
                }
            }
        }

        return tm;
    }
}

// Time: O(n * m)
// Space: O(n * m)
