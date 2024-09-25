package Strivers.Graphs.Hard;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    // now solved using bfs
    class Solution {
        public int numEnclaves(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            boolean[][] visited = new boolean[n][m]; // this will make sure that we won't visit the same nodes again and again
            // we will start the bfs
            Queue<Node> queue = new LinkedList<>();

            // go through the grid and check for the lands which are present at the border, and insert them into queue
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1){ // check if the current land is present at the border
                        Node node = new Node(i, j); // if yes then add into queue
                        queue.offer(node);
                        visited[i][j] = true; // mark the current place as visited
                    }
                }
            }



            // this two arrays will help us to efficiently check the four directions of the current place
            int[] dRow = {1, 0, -1, 0};
            int[] dCol = {0, 1, 0, -1};

            // start the bfs
            while(!queue.isEmpty()){
                Node current = queue.poll(); // get the first node out of the queue
                int row = current.row;
                int col = current.col;
                // check in the four side of the current location
                for(int i = 0; i < 4; i++){ // check for the four sides
                    int nRow = row + dRow[i];
                    int nCol = col + dCol[i];

                    if(isValid(nRow, nCol, n, m) && !visited[nRow][nCol] && grid[nRow][nCol] == 1){ // check if any of the side is connected to that land or not
                        // if valid then, add that node into queue
                        Node node = new Node(nRow, nCol);
                        queue.offer(node);
                        visited[nRow][nCol] = true; // mark the valid land as visited
                    }
                }
            }

            // now check of the lands
            int lands = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!visited[i][j] && grid[i][j] == 1){ // count the number of lands that are not visited and cant be reached from the border
                        lands++;
                    }
                }
            }

            return lands;
        }

        private boolean isValid(int row, int col, int n, int m){
            return (row < n && row >= 0 && col < m && col >= 0);
        }
        class Node{
            int row, col;
            Node(int row, int col){
                this.row = row;
                this.col = col;
            }
        }
    }
    // solved using dfs
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        // traverse and find the location which is boundary and has 1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // check if the current location is not visited also
                if((i == 0 || j == 0 || i == n - 1 || j == m - 1) && !visited[i][j] && grid[i][j] == 1){
                    // start the dfs from that location
                    dfs(grid, visited, i, j, n, m);
                }
            }
        }

        int ans = 0; // this will count the number of lands which are not visited from the boundary
        // now traverse through grid
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == 1) ans++; // increment the ans if current location has 1 and not visited yet
            }
        }
        // return the ans
        return ans;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col, int n, int m){
        // mark the current location as visited
        visited[row][col] = true;

        // check for the four directions
        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        // now check
        for(int i = 0; i < 4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            // check if the location has what we want
            if(isValid(nRow, nCol, n, m) && !visited[nRow][nCol] && grid[nRow][nCol] == 1){
                dfs(grid, visited, nRow, nCol, n, m);
            }
        }
    }

    private boolean isValid(int row, int col, int n, int m){
        return (row < n && row >= 0 && col < m && col >= 0);
    }
}
