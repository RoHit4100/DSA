package Strivers.Graphs.Medium;
import java.util.*;
public class RottenOranges {
    public static int minTimeToRot(int[][] grid, int n, int m) {
        // Write your code here.
        // Code here
        // to solve this problem we will use the bfs
        Queue<Node> queue = new LinkedList<>();
        int fresh = 0; // this will keep the count of the total fresh oranges
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // check if the current orange is roted or not
                if(grid[i][j] == 2){ // this means orange is rotted
                    // add that into queue
                    Node node = new Node(i, j, 0);
                    queue.offer(node);
                }else if(grid[i][j] == 1){ // count the fresh oranges
                    fresh++;
                }
            }
        }

        // now take pointer for tracking the max time
        int maxTime = 0;
        int converted = 0; // this will keep track of how many oranges are converted


        // now create an array which will help to check the four sides of the orange
        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        // now start the bfs
        while(!queue.isEmpty()){
            // first get the top of the node from the queue
            Node current = queue.poll();
            // get the row, time, and col
            int row = current.row;
            int col = current.col;
            int minute = current.minute;

            maxTime = Math.max(maxTime, minute); // get the max time
            // now check for the four directions
            for(int i = 0; i < 4; i++){
                int newRow = row + dRow[i]; // get the new row and cols
                int newCol = col + dCol[i];

                // check if newRow and newCol are in bound or not
                if(isValid(newRow, newCol, n, m) && grid[newRow][newCol] == 1){
                    // increase the converted, as we have found the fresh orange
                    converted++;
                    // convert the fresh into rotten
                    grid[newRow][newCol] = 2;
                    // add that orange into queue
                    Node node = new Node(newRow, newCol, minute + 1);
                    queue.offer(node);
                }
            }
        }

        // check if the all the fresh oranges are converted or not
        if(fresh != converted) return -1;
        return maxTime;
    }


    private static boolean isValid(int row, int col, int n, int m){
        return (row >= 0 && row < n && col < m && col >= 0);
    }

    static class Node{
        int row, col, minute;
        Node(int row, int col, int minute){
            this.row = row;
            this.col = col;
            this.minute = minute;
        }
    }
}
