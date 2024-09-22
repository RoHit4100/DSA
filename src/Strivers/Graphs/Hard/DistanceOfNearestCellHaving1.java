package Strivers.Graphs.Hard;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        // Initialize the queue for BFS
        Queue<Node> queue = new LinkedList<>();
        // Visited matrix to keep track of visited cells
        boolean[][] visited = new boolean[n][m];
        // Distance matrix to store the result
        int[][] dist = new int[n][m];

        // Initialize the distance matrix to a large value and populate the queue with all '1's
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    queue.offer(new Node(i, j, 0)); // Add '1' nodes to the queue
                    visited[i][j] = true; // Mark these cells as visited
                    dist[i][j] = 0; // Distance to itself is 0
                }
            }
        }

        // Directions for moving in 4 possible directions
        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        // Perform BFS
        while(!queue.isEmpty()){
            Node current = queue.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            // Explore the 4 possible directions
            for(int i = 0; i < 4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // Check if the new cell is valid and not yet visited
                if(isValid(newRow, newCol, n, m) && !visited[newRow][newCol]){
                    // Update the distance for the new cell
                    dist[newRow][newCol] = distance + 1;
                    // Mark the new cell as visited
                    visited[newRow][newCol] = true;
                    // Add the new cell to the queue
                    queue.offer(new Node(newRow, newCol, distance + 1));
                }
            }
        }

        return dist;
    }

    private boolean isValid(int row, int col, int n, int m){
        return (row >= 0 && row < n && col >= 0 && col < m);
    }

    class Node{
        int row, col, distance;
        Node(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}
