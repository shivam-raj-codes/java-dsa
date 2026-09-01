package com.shivam.graphs.DisjointSetDs.problem;

// https://www.geeksforgeeks.org/problems/connecting-the-graph/1

//class DisjointSet {
//    int[] rank;
//    int[] parent;
//
//    DisjointSet(int n) {
//        rank = new int[n + 1];
//        parent = new int[n + 1];
//
//        for (int i = 0; i <= n; i++) {
//            parent[i] = i;
//            rank[i] = 0;
//        }
//    }
//
//    // Find ultimate parent + path compression
//    public int findUPar(int node) {
//        if (node == parent[node]) {
//            return node;
//        }
//
//
//        int ultimateParent = findUPar(parent[node]);
//        parent[node] = ultimateParent; /// path compression
//
//        return parent[node];
//    }
//
//    public void unionByRank(int u, int v) {
//        int ulp_u = findUPar(u); /// ultimate parent of 'u'
//        int ulp_v = findUPar(v); /// ultimate parent of 'v'
//
//        /// Already in same component
//        if (ulp_u == ulp_v) {
//            return;
//        }
//
//        /// Smaller rank Tree goes below bigger rank Tree
//        // as smaller guy connected to larger => no increment in height.
//        if (rank[ulp_u] < rank[ulp_v]) {
//            parent[ulp_u] = ulp_v;
//        }
//        else if (rank[ulp_v] < rank[ulp_u]) {
//            parent[ulp_v] = ulp_u;
//        }
//        else {
//            // Same rank → choose either as parent & height increases
//            parent[ulp_v] = ulp_u;
//            // v attach to u => u size++
//            rank[ulp_u]++;
//        }
//    }
//}

public class ConnectingTheGraphs {
    public int minEdgesReq(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n); // Disj Set for all the nodes

        int cntExtras = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (ds.findUPar(u) == ds.findUPar(v)) {
                // u & v have same ultimate parent => already connected
                cntExtras++;
            }
            else {
                // connect
                ds.unionByRank(u, v);
            }
        }

        // count connected components 0 -> V(vertices)
        int cntC = 0; /// connected Components
        for (int i = 0; i < n; i++) {
            if (ds.findUPar(i) == i) {
                cntC++;
            }
        }

        int ans = cntC - 1;
        if (cntExtras >= ans) {
            return ans;
        }
        return -1;
    }
}
