package com.shivam.graphs.algorithm;

import java.util.*;

class Disjoint_Set {
    int[] size;
    int[] parent;

    // Constructor
    Disjoint_Set(int n) {
        size = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    // Ultimate parent
    public int findUPar(int node) {
        /// base - case
        if (node == parent[node]) {
            // now we have the ultimate parent
            return node;
        }

        parent[node] = findUPar(parent[node]); /// path compression
        return parent[node];
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // Already belong to the same component
        if (ulp_u == ulp_v) {
            return;
        }

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v; /// parent of 'ulp_u' becomes parent of 'ulp_v'.
            size[ulp_v] = size[ulp_v] + size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_u] + size[ulp_v];
        }
    }
}


public class KruskalSAlgorithmUsingDisjointSetDS {
    static class Edges {
        int src;
        int destination;
        int weight;

        Edges(int src, int destination, int weight) {
            this.src = src;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        ArrayList<Edges> edges = new ArrayList<>();

        // we are using Disjoint Set get ignore same addition of edge
        for (int i = 0; i < V; i++) {
            for(ArrayList<Integer> it : adj.get(i)) {
               int adjNode = it.get(0);
               int wt = it.get(1);
               int node = i;

               edges.add(new Edges(node, adjNode, wt));
            }
        }

        Disjoint_Set ds = new Disjoint_Set(V);

        /// Sort edges according to weight
        edges.sort((a, b) -> a.weight - b.weight);

        int mstWt = 0;
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).destination;

            if (ds.findUPar(u) != ds.findUPar(v)) {
                // belong to different component => will take in MST.
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }
        return mstWt;
    }
}
