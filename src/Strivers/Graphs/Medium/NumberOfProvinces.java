package Strivers.Graphs.Medium;

import java.util.ArrayList;

public class NumberOfProvinces {
    // this is using adjacency list, for traversal
    public int findCircleNum(int[][] isConnected) {
        // first create the adj list for the given matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // this will store the adjacency list, for which that particular index
        // will denote the node, or vertex, and list attach to that index will denote the neighbours
        int n = isConnected.length; // get the number of total nodes present in the graph
        for(int i = 0; i < n; i++){ // create list to store the neighbours
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){ // now add the neighbours into adjacency list
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){ // add only if the given box is 1
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        // now adj list is created we can perform the logic here
        boolean[] visited = new boolean[n]; // visited array
        int count = 0; // set the count for 0
        for(int i = 0; i < n; i++){ // traverse for each node
            if(!visited[i]){ // check if that node is visited or not
                count++; // if not visited then start dfs for that graph
                dfs(adj, visited, i);
            }
        }

        // in the end return the count
        return count;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node){
        visited[node] = true; // mark the given node as visited

        for(int neighbour: adj.get(node)){ // go through each neighbour for that node
            if(!visited[neighbour]){ // start traversal only if that node is not previously visited
                dfs(adj, visited, neighbour);
            }
        }
    }
}
