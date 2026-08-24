package com.shivam.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    // N = No. of Strings
    // K = No. of alphabet from Standard English Alphabet
    public String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            // List for K - sets
            adj.add(new ArrayList<>());
        }

        /// Prep Directed - Graph
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int length = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < length; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    // s1 Appears before s2 => s1 -> s2
                    /// to Store in terms of : 0 1 2 3... => subtract 'a' so that char Covert to Ascii-value & perform Subtraction.
                    adj.get((s1.charAt(ptr)) - 'a').add((s2.charAt(ptr)) - 'a');
                    break;
                }
            }
        }

        /// TopoSort of this D-Graph
        List<Integer> topo = topoSort(K, adj); /// K -> No. of vertices/

        /// convert topoSort into String
        StringBuilder ans = new StringBuilder();

        /// forEach on list
        for (int it : topo) {
            ans.append((char) (it + 'a'));
        }

        return ans.toString();
    }

    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        ///  in - Degree
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            /// all vertex with inDeg = 0 : put in Queue
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }


        ArrayList<Integer> topo = new ArrayList<>(); /// topo-Sort
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            topo.add(node); /// add in list

            /// node is in your topo-Sort
            /// so, please remove it from the inDegree[]
            for (int it: adj.get(node)) {
                inDegree[it]--; /// remove from inDegree[].
                if (inDegree[it] == 0) {
                    /// after removing, the inDegree of 'it' becomes-> 0
                    /// => have one more ele to put in topoSort
                    q.offer(it);
                }
            }
        }
        return topo;
    }
}

// Time: 
