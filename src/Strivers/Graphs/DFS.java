package Strivers.Graphs;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfs = new ArrayList<>(); // this will store the dfs traversal
        boolean[] visited = new boolean[V]; // this will store all the visited nodes
        visited[0] = true; // mark the starting node as visited
        dfs.add(0); // add the first node into arraylist
        dfs(adj, visited, dfs, 0); // start the bfs
        return dfs;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs, int node){
        if(adj.get(node) == null){ // return if the current node has no neighbours
            return;
        }

        // get the neighbours for current node
        ArrayList<Integer> neighbours = adj.get(node);
        for(int neighbour: neighbours){ // traverse for each node
            if(!visited[neighbour]){ // if that nodes is not visited then visit that node
                dfs.add(neighbour); // add that node into list
                visited[neighbour] = true; // mark the current node as visited
                dfs(adj, visited, dfs, neighbour); // call dfs for that node
            }
        }
    }
}
