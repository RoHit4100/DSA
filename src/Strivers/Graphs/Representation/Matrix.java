package Strivers.Graphs.Representation;

public class Matrix {
    static int[][] adjMatrix(int n, int m, int[][] arr){
        int[][] adj = new int[n + 1][m + 1];

        for(int[] edge: arr){
            int u = edge[0];
            int v = edge[1];
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        return adj;
    }
}
