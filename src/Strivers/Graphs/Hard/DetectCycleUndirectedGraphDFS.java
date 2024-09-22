package Strivers.Graphs.Hard;
import java.util.*;
public class DetectCycleUndirectedGraphDFS {
    // Function to detect cycle in an undirected graph using DFS
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Boolean array to track visited nodes, initialized to false
        boolean[] visited = new boolean[V];

        // Traverse all nodes in case the graph is disconnected (has multiple components)
        for (int i = 0; i < V; i++) {
            // If the node is not visited, perform DFS
            if (!visited[i]) {
                // Check if a cycle is found starting from node i
                boolean cycle = dfs(adj, visited, i, -1);
                if (cycle) return true; // Return true if a cycle is detected
            }
        }
        // If no cycle is found in any component, return false
        return false;
    }

    // Helper method to perform DFS and detect a cycle
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, int parent) {
        // Mark the current node as visited
        visited[node] = true;

        // Iterate through all the neighbors of the current node
        for (int neighbour : adj.get(node)) {
            // If the neighbor is not visited, perform DFS on the neighbor
            if (!visited[neighbour]) {
                // Recursive DFS with the current node as the parent of the neighbor
                if (dfs(adj, visited, neighbour, node)) {
                    return true; // Cycle found, propagate the result upwards
                }
            }
            // If the neighbor is visited, and it's not the parent, there is a cycle
            else if (neighbour != parent) {
                return true; // Cycle detected due to back edge
            }
        }

        // If no cycle is found in this DFS path, return false
        return false;
    }

}
