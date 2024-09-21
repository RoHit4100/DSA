package Strivers.Graphs.Hard;

import java.util.ArrayList;

public class CompleteComponents {
    class Solution {
        private int v; // this will count the number or vertex
        private int e; // this will count the number of edges
        public int countCompleteComponents(int n, int[][] edges) {
            // let's first create the adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            // add n list for n nodes
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }

            // now add the neighbours
            for(int[] edge: edges){
                int first = edge[0];
                int second = edge[1];

                adj.get(first).add(second);
                adj.get(second).add(first);
            }

            // take the visited
            boolean[] visited = new boolean[n];
            int completeComponents = 0;
            // now start the traversals for the components
            for(int i = 0; i < n; i++){
                if(!visited[i]){ // only visit if not visited already
                    v = 0; // initialize number of vertex and edges to zero
                    e = 0;
                    dfs(adj, visited, i);
                    int ll = v * (v - 1) / 2; // use this formula to check
                    if(ll * 2 == e){
                        completeComponents++;
                    }
                }
            }

            return completeComponents;
        }

        private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node){
            // mark the current node as visited
            visited[node] = true;
            v++; // increment the nodes counter for each dfs
            // traverse for neighbours
            for(int neighbour: adj.get(node)){
                e++; // increment the edges for each neighbour
                if(!visited[neighbour]){
                    dfs(adj, visited, neighbour);
                }
            }
        }
    }
}
