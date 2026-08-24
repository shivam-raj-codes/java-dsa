package com.shivam.graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

// Given a binary matrix mat[][] of size n × m containing values 0 and 1, and a source cell src[] and
// destination cell dest[], find the minimum number of steps required to reach the destination cell from the source cell. From any cell, you can move to its adjacent cells in the up, down, left, and right directions.
// 1 represents a traversable cell.
// 0 represents a blocked cell that cannot be visited.
// If the destination cannot be reached from the source, return -1.
public class ShortestDistanceInBinaryMaze {
    // using dijkstra

     static class Pair {
         int first, second, third;

         Pair(int first, int second, int third) {
             this.first = first;
             this. second = second;
             this.third = third;
         }
     }

    public static int shortestPath(int[][] mat, int[] src, int[] dest) {
         int n = mat.length;
         int m = mat[0].length;

         /// important edge case :
        if (src[0] == dest[0] && src[1] == dest[1] && mat[src[0]][src[1]] == 1) {
            // already standing at destination && given src-location is 1
            return 0;
        }

        // {dist, row, col}
        Queue<Pair> q = new LinkedList<>(); /// Queue
        int[][] dist = new int[n][m]; /// distance[][]

        final int INF = (int) (1e9);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = INF;
            }
        }

        dist[src[0]][src[1]] = 0; /// source

        q.offer(new Pair(0, src[0], src[1])); /// initial push

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int distance = p.first;
            int row = p.second;
            int col = p.third;

            // 4 - direction
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && mat[nRow][nCol] == 1 && distance + 1 < dist[nRow][nCol]) {
                    dist[nRow][nCol] = 1 + distance;

                    if (nRow == dest[0] && nCol == dest[1]) {
                        return distance + 1; /// ans. Stop here.
                    }
                    q.offer(new Pair(1 + distance, nRow, nCol)); /// push in Q
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1, 1, 1},{1, 1, 1, 1, 1},{1, 1, 1, 1, 0},{1, 0, 1, 0, 1}};
        int[] src= {0, 1};
        int[] dest = {2, 2};

        System.out.println(shortestPath(mat, src, dest));
    }
}
