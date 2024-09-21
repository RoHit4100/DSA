package Strivers.Graphs.Hard;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoodComponents {
    class Solution {
        public static int findNumberOfGoodComponent(int e, int V, int[][] edges) {
            // Create adjacency list to represent the graph
            // Index 0 is left unused to match 1-based vertex numbering
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i <= V; i++){
                adj.add(new ArrayList<>());
            }

            // Populate the adjacency list with edges
            // For each edge, add both directions as it's an undirected graph
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            // Create a boolean array to keep track of visited vertices
            // Size is v+1 to match 1-based vertex numbering
            boolean[] visited = new boolean[V + 1];

            int goodComponents = 0;  // Counter for good components

            // Iterate through all vertices
            for(int i = 1; i <= V; i++){
                if(!visited[i]){
                    // If a vertex is not visited, it's the start of a new component
                    ArrayList<Integer> component = new ArrayList<>();
                    dfs(adj, visited, i, component);

                    // Check if the discovered component is a good component
                    if(isGoodComponent(adj, component)){
                        goodComponents++;
                    }
                }
            }

            // Return the total number of good components found
            return goodComponents;
        }

        // Depth-First Search to explore and collect all vertices in a component
        private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, ArrayList<Integer> component){
            visited[node] = true;  // Mark current node as visited
            component.add(node);   // Add current node to the component

            // Explore all unvisited neighbors
            for(int neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    dfs(adj, visited, neighbour, component);
                }
            }
        }

        // Check if a component is fully connected (i.e., a good component)
        private static boolean isGoodComponent(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> component){
            int size = component.size();

            // For a component to be fully connected, each node must be connected to
            // all other nodes in the component (i.e., have size-1 neighbors)
            for(int node : component){
                if(adj.get(node).size() != size - 1){
                    return false;  // If any node doesn't have size-1 neighbors, it's not fully connected
                }
            }
            return true;  // If all nodes have size-1 neighbors, it's a good component
        }
    }
}
