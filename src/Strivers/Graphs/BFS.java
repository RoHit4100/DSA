package Strivers.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        // first create the visited array having the length of V
        int[] visited = new int[V];
        // we have the adj list, so no need to create that
        // now start the bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // add the 0th node, which will be the first node or starting node for the traversal
        visited[0] = 1; // mark the first node as visited
        while (!queue.isEmpty()){ // start bfs
            int size = queue.size(); // get the size of the queue
            for(int i = 0; i < size; i++){ // pop all the elements present in the queue
                int currentNode = queue.poll(); // get the current node
                bfs.add(currentNode); // add the current node into the answer
                // go through all the neighbours of the currentNode
                ArrayList<Integer> neighbours = adj.get(currentNode); // get the neighbours for current node
                for(int node: neighbours){ // go through each and every neighbour node of the current node
                    if(visited[node] != 1){  // check if the current node is visited or not
                        visited[node] = 1; // if not visited the mark that node as visited and then add into the queue
                        queue.offer(node);
                    }
                }
            }
        }
        // return the bfs
        return bfs;
    }
}
