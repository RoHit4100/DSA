package Strivers.Graphs.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    // using bfs to solve this question
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initialCol = image[sr][sc]; // initial color

        if (initialCol == color) { // check if the colors are same
            return image; // Avoid infinite loop if starting pixel already has the target color
        }

        Queue<Node> queue = new LinkedList<>(); // to perform the bfs
        queue.offer(new Node(sr, sc));
        image[sr][sc] = color; // Fill the starting pixel

        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        // Start BFS
        while (!queue.isEmpty()) {
            Node current = queue.poll(); // get the top
            int row = current.row;
            int col = current.col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (isValid(newRow, newCol, n, m) && image[newRow][newCol] == initialCol) {
                    image[newRow][newCol] = color; // change the color
                    queue.offer(new Node(newRow, newCol)); // add the new location into the queue
                }
            }
        }

        return image;
    }

    private boolean isValid(int row, int col, int n, int m) {
        return (row >= 0 && row < n && col >= 0 && col < m);
    }

    private class Node {
        int row, col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }



    // solved using dfs
    public class Solution
    {
        private static int n, m;
        public static int[][] floodFill(int[][] image, int x, int y, int newColor)
        {
            // Write your code here
            // solve this question using dfs
            n = image.length;
            m = image[0].length;

            int initialCol = image[x][y];
            // check if the initial color and new color are same or not
            if(newColor == initialCol) return image;

            // start the dfs
            int[] dRow = {1, 0, -1, 0};
            int[] dCol = {0, 1, 0, -1};
            dfs(image, x, y, initialCol, newColor, dRow, dCol);

            return image;
        }

        private static void dfs(int[][] image, int row, int col, int initialCol, int newColor, int[] dRow, int[] dCol){
            image[row][col] = newColor; // change the color

            // check for the 4 directions
            for(int i = 0; i < 4; i++){ // check for each side
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];
                if(isValid(newRow, newCol) && image[newRow][newCol] == initialCol){ // if location is valid then visit and change the color
                    dfs(image, newRow, newCol, initialCol, newColor, dRow, dCol);
                }
            }
        }

        private static boolean isValid(int row, int col){
            return (row < n && row >= 0 && col < m && col >= 0);
        }
    }

}
