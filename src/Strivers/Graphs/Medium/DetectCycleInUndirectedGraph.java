package Strivers.Graphs.Medium;
import java.util.*;
public class DetectCycleInUndirectedGraph {
    // Function to detect cycle in an undirected graph using BFS
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to track visited nodes, initialized to false
        boolean[] visited = new boolean[V];

        // Loop through each vertex in case the graph has multiple components
        for (int i = 0; i < V; i++) {
            // If the vertex is not visited, check for a cycle in its component
            if (!visited[i]) {
                // If a cycle is detected, return true
                boolean cycle = checkCycle(i, visited, adj);
                if (cycle) return true;
            }
        }
        // If no cycle is found in any component, return false
        return false;
    }

    private boolean checkCycle(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        // Mark the starting node as visited
        visited[start] = true;

        // Queue to perform BFS, stores pairs of current node and its parent node
        Queue<Pair> queue = new LinkedList<>();

        // Start BFS with the starting node and -1 as its parent (no parent for the start)
        queue.offer(new Pair(start, -1));

        // Process the queue until all connected nodes are visited
        while (!queue.isEmpty()) {
            // Dequeue the front element
            Pair pair = queue.poll();
            int current = pair.current;
            int parent = pair.parent;

            // Traverse all the adjacent nodes of the current node
            for (int neighbour : adj.get(current)) {
                // If the neighbor is not visited, mark it visited and enqueue it
                if (!visited[neighbour]) {
                    visited[neighbour] = true;  // Mark the neighbor as visited
                    queue.offer(new Pair(neighbour, current));  // Add to the queue with current as its parent
                }
                // If the neighbor is visited, and it's not the parent, a cycle is detected
                else if (neighbour != parent) {
                    return true;  // Cycle found
                }
            }
        }

        // If no cycle is found in this BFS traversal, return false
        return false;
    }

    // Helper class to store a node and its parent during BFS
    private class Pair {
        int current, parent;

        // Constructor to initialize current node and its parent
        Pair(int current, int parent) {
            this.current = current;
            this.parent = parent;
        }
    }

}
