package Strivers.Graphs.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];

        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        // now find all the places which has the 0
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    Node node = new Node(i, j, 0);
                    queue.offer(node);
                }
            }
        }

        // now start the bfs
        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            Node current = queue.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            dist[row][col] = distance;
            // check the four directions
            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                // check if valid or not
                if(isValid(nRow, nCol, n, m) && !visited[nRow][nCol]){
                    visited[nRow][nCol] = true;
                    Node node = new Node(nRow, nCol, distance + 1);
                    queue.offer(node);
                }
            }
        }

        return dist;
    }

    private boolean isValid(int row, int col, int n, int m){
        return (row >= 0 && row < n && col < m && col >= 0);
    }

    private class Node{
        int row, col, distance;
        Node(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}
