package com.shivam.graphs.DisjointSetDs.problem;

import java.util.HashSet;
import java.util.Map;

public class MaximumStoneRemoval {
    public int maxRemove(int[][] stones, int n) {
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {

            int currentRow = stones[i][0];
            int currentCol = stones[i][1];

            if (currentRow > maxRow) {
                maxRow = currentRow;
            }

            if (currentCol > maxCol) {
                maxCol = currentCol;
            }
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashSet<Integer> stonesNode = new HashSet<>();        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0]; /// row
            int nodeCol = stones[i][1] + maxRow + 1; /// col
            ds.unionByRank(nodeRow, nodeCol); // go ahead and combine them

            /// This node is being used in our stones, so remember it.
            stonesNode.add(nodeRow);
            stonesNode.add(nodeCol);
        }

        int cnt = 0;
        // iterate on map
        for ( int node : stonesNode) {
            if (ds.findUPar(node) == node) {
                // ulP of itself => its boss
                cnt++;
            }
        }

        return n - cnt;
    }
}
