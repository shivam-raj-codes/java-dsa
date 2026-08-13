package com.shivam.graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// Striver version: uses 1e9 as INF for unreachable nodes
public class ShortestPathInDAG {
    static class Pair{
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    /// If the problem expects 1e9/infinity for unreachable nodes.
    public double[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // adj - List initialise
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        // input contains edges, So we loop through the number of edges (M):
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }


        // Step 1: topo Sort
        /// Time: O(N + M)
        boolean[] visited = new boolean[N];
        Stack<Integer> st = new Stack<>();

        // for all components
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, st);
            }
        }

        // step2: do the distance thing
        double[] distance = new double[N];
        Arrays.fill(distance, 1e9); /// initialise with INFINITY

        distance[0] = 0; /// src - Node initialise with -> 0

        /// Time: O(N + M) -> N -> all vertices & M -> all neighbours that is no. of edges.
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            /// go across all adj. node
            for (Pair it : adj.get(node)) {
                int v = it.first; // adjacent - node
                int wt = it.second; // weight

                /// relaxation of edge
                if (distance[node] + wt < distance[v]) {
                    distance[v] = distance[node] + wt;
                }
            }
        }

        return distance;
    }

    // TopoSort dfs:
    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true; /// mark as visited

        // all adj-Node
        for (Pair it: adj.get(node)) {
            int v = it.first;
            if(!vis[v]) {
                /// as not visited
                topoSort(v, adj, vis, st);
            }
        }
        // no further adj-Node => push in stack
        st.push(node);
    }
}


// GFG problem statement:-
//Given a Directed Acyclic Graph of N vertices from 0 to N-1 and M edges and a 2D Integer array edges, where there is a
//directed edge from vertex edge[i][0] to vertex edge[i][1] with a distance of edge[i][2] for all i.

//Find the shortest path from source vertex to all the vertices and if it is impossible to reach any vertex,
//then return -1 for that vertex. The source vertex is assumed to be 0.

/*
🌟 GFG Submission Code: with Some Extra check
🌟/// for unreachable GFG wants to return -1.
static class Pair {
		int first, second;
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public ArrayList<Integer> shortestPath(int V, int[][] edges) {
		int N = V;
		int M = edges.length;
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

		// adj - List initialise
		for (int i = 0; i < N; i++) {
			adj.add(new ArrayList<>());
		}

		// Add edges
		// input contains edges, So we loop through the number of edges (M):
		for (int i = 0; i < M; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int wt = edges[i][2];
			adj.get(u).add(new Pair(v, wt));
		}

		// Step 1: topo Sort
		boolean[] visited = new boolean[N];
		Stack<Integer> st = new Stack<>();

		// for all components
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				topoSort(i, adj, visited, st);
			}
		}

		// step2: do the distance thing
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE); /// initialise with INFINITY

		distance[0] = 0; /// src - Node initialise with -> 0

		while (!st.isEmpty()) {
			int node = st.peek();
			st.pop();

			// Only process reachable nodes
			/// go across all adj. node
			for (Pair it : adj.get(node)) {
				int v = it.first; // adjacent - node
				int wt = it.second; // weight

				/// relaxation of edge
				if (distance[node] != Integer.MAX_VALUE && distance[node] + wt < distance[v]) {
					distance[v] = distance[node] + wt;
				}
			}

		}

		// After the algorithm finishes, some vertices may still have:

		// distance[i] = Integer.MAX_VALUE

		// That means:

		// "No path from 0 to this vertex."

		// GFG wants that represented as:

		// -1
		// Unreachable nodes -> -1
		for (int i = 0; i < N; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				distance[i] = -1;
			}
		}

		// Convert int[] -> ArrayList<Integer>
		ArrayList<Integer> result = new ArrayList<>();

		for (int d : distance) {
			result.add(d);
		}

		return result; // return List as Answer
	}

	private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> st) {
		vis[node] = true; /// mark as visited

		// all adj-Node
		for (Pair it: adj.get(node)) {
			int v = it.first;
			if (!vis[v]) {
				/// as not visited
				topoSort(v, adj, vis, st);
			}
		}
		// no further adj-Node => push in stack
		st.push(node);
	}
 */
