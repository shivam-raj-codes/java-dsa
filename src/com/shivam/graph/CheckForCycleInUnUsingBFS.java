package com.shivam.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckForCycleInUnUsingBFS {

    class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first; /// node
            this.second = second; /// node's parent
        }
    }

    private boolean detect(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[src] = true;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, -1));

        ///  bfs
        while (!q.isEmpty()) {

            Pair p = q.poll();
            int nodeCurrent = p.first;
            int parent = p.second;

            // go to all its neighbours
            for (int neighbour: adj.get(nodeCurrent)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true; /// mark as visited
                    q.offer(new Pair(neighbour, nodeCurrent)); /// push it with from which parent the 'node' came
                }

                /// A node is already visited, but now we are reaching that same node from a different parent → cycle exists.
                /// Same node can be reached from two different parents → cycle.
                /// if someOne is visited & it didn't come form it


                /// Agar kisi Node ka neighbour uska Parent hi hai & vo neighbour visited hai => its Normal
                /// But, apart from parent as neighbour there is another neighbour that is already VISITED but this is Not parent of that Node
                /// so Node think, I didn't come from him but someone already touched him, and Again I can tough him => Extra Edge => Cycle Exist.

                else if (parent != neighbour) { /// some neighbour which is already VISITED & that VISITED neighbour is not the parent of current-Node => cycle found
                    // Visited + Not Parent = Cycle
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // 0 - based
        boolean[] visited = new boolean[v];

        ///  we say a Graph to have a cycle if any of the component have the Cycle.
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (detect(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
