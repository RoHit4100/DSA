package Strivers.Graphs.Representation;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AdjList {
    // this is for undirected graph
    // if given graph is directed then only in the given order
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adj = new ArrayList<>();

        // now create V lists, to store their neighbours or edges
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        // now traverse through edges and store the neighbour for each vertex or node
        for(int[] edge: edges){
            int u = edge[0]; // get the u
            int v = edge[1]; // get the v

            adj.get(u).add(v); // get the arrayList present at u, and add v to it
            // NOTE: THIS WILL NOT PRESENT IN THE CASE OF DIRECTED GRAPH
            adj.get(v).add(u); // get the arrayList present at v and add u to it
        }

        return adj;
    }

    // to store the weighted graph in adj list, we will store the neighbour and weight as pair
    class Pair{
        int edge;
        int weight;
        Pair(int edge, int weight){
            this.edge = edge;
            this.weight = weight;
        }
    }

    public List<List<Pair>> printGraphWeighted(int V, int edges[][]) {
        List<List<Pair>> adj = new ArrayList<>();

        // first add the v lists into adj
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        // now traverse through given edges
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adj.get(u).add(new Pair(v, weight));
            // NOTE: this line won't be their for directed graph
            adj.get(v).add(new Pair(u, weight));
        }
        return adj;
    }
}
