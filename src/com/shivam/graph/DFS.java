package com.shivam.graph;

import java.util.ArrayList;

public class DFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
        visited[node] = true;

        list.add(node); /// ans

        /// main - logic Of recursion
        // traverse for all its neighbours
        for (int it : adj.get(node)) { // It only loops over the neighbors of that node --> O(2*E)
            if (!visited[it]) {
                dfs(it, adj, visited, list); /// recursive - call -> O(N)
            }
        }
    }


    public static ArrayList<Integer> dfsOfGraph(int start, int vertices, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();

        boolean[] visited = new boolean[vertices + 1];

        ///  call dfs():
        dfs(start, adj, visited, list);

        /// resultant - list
        return list;
    }



    /// Main - fn
    public static void main(String[] args) {
        int n = 8; /// total node / vertex

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>()); // internal arrayList.
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 5);
        addEdge(adj, 2, 6);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 8);
        addEdge(adj, 7, 8);

        System.out.println("Adjacency List: ");
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        System.out.println("\nDFS Traversal On UnDirected Graph: ");
        System.out.println(dfsOfGraph(1, n, adj));
    }
}

// Time : O(N + 2*Edges)
// Space: O(N) + O(N) + O(N) ~ O(N).

/*
DFS/BFS

🌟Visit every vertex once.
🌟Visit every edge once (or twice in an undirected graph).

-> Therefore:

🌟Time = O(V + E)

 */