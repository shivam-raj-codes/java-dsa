package com.shivam.graphs.DisjointSetDs.problem;

import java.util.ArrayList;

// https://takeuforward.org/plus/dsa/problems/number-of-islands-ii
// problem statement:
// Number of Islands II
//You are given an n × m grid that is initially filled with water (0).
//You are given a 2D array operators, where operators[i] = [row, col] represents an operation that turns the cell (row, col) into land (1).
//After each operation, return the number of islands present in the grid.
//An island is a group of connected land cells. Two land cells are connected if they are adjacent horizontally or vertically (up, down, left, or right). Diagonal cells are not considered connected.
//If an operation is performed on a cell that is already land, the number of islands remains unchanged.
//Return an ArrayList<Integer> containing the number of islands after each operation.
//Example:
//Input:
//n = 4
//m = 5
//operators = [[1,1], [1,2], [2,1], [3,3]]
//Output:
//[1, 1, 1, 2]

/// ⚠️ Disclaimer: Always Disjoint Set DS should be written in same file as code solution is in.

public class NumberOfIslandsII {
    private boolean isValid(int adjR, int adjC, int n, int m) {
        return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m;
    }

    /// n, m denoting the row and column of the 2D matrix
    public ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        int[][] vis = new int[n][m];

        int cnt = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        // go through all the query
        for (int i = 0; i < operators.length; i++) {
            int row = operators[i][0];
            int col = operators[i][1];

            if (vis[row][col] == 1) {
                // as its already visited => already island
                // no change in cnt
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1; /// marks as visited
            cnt++; /// & count is as Individual element

            int[] delR = {-1, 0, 1, 0};
            int[] delC = {0, 1, 0, -1};

            for (int j = 0; j < 4; j++) {
                int adjR = row + delR[j];
                int adC = col + delC[j];

                if (isValid(adjR, adC, n, m)) {
                    if (vis[adjR][adC] == 1) {
                        // adjacent guy is island
                        int nodeNo = row * m + col; /// node No.
                        int adjNodeNo = adjR * m + adC; /// adjacent Node No.

                        // is it already connected ?
                        if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                            /// not connecting
                            // go ahead and connect & also reduce cnt by -> -1.
                            ds.unionByRank(nodeNo, adjNodeNo);
                            cnt--;
                        }
                    }
                }
            }
            ans.add(cnt);
        }

        return ans;
    }


    public static void main(String[] args) {

        NumberOfIslandsII obj = new NumberOfIslandsII();

        int n = 4;
        int m = 5;

        int[][] operators = {
                {1, 1},
                {1, 2},
                {2, 1},
                {3, 3}
        };

        ArrayList<Integer> result = obj.numOfIslands(n, m, operators);

        System.out.println(result);
    }
}
