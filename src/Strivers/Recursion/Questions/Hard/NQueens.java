package Strivers.Recursion.Questions.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        findWays(ans, board, n, 0);
        return ans;
    }

    private void findWays(List<List<String>> ans , boolean[][] board, int n, int row){
        if(row == n){
            List<String> solution = new ArrayList<>();
            ans.add(addSolution(solution, board));
            return;
        }

        for(int i = 0; i < n; i++){
            if(isSafe(board, row, i)) {
                board[row][i] = true;
                findWays(ans, board, n, row + 1);
                board[row][i] = false; // backtrack
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col){
        // first check in the same row, from starting from 0 till row
        for(int i = 0; i <= row; i++){
            if(board[i][col]){
               return false;
            }
        }

        // check for right diagonal
        int maxRight = Math.min(row, col);
        for(int i = 1; i <= maxRight; i++){
            if(board[row - i][col - i]){
                return false;
            }
        }

        // check for left diagonal
        int maxLeft = Math.min(row, board.length - col - 1);
        for(int i = 0; i <= maxLeft; i++){
            if(board[row - i][col + i]){
                return false;
            }
        }

        // if none of the loop return false, then return true;
        // as this location is safe to place the queens
        return true;
    }

    // function to add solution
    private List<String> addSolution(List<String> solution, boolean[][] board){
        for(boolean[] row: board){
            StringBuilder line = new StringBuilder();
            for(boolean place: row){
                if(place){
                    line.append("Q");
                }else{
                    line.append(".");
                }
            }
            solution.add(line.toString());
        }
        return solution;
    }
}

class NQueensUsingCols{
    // we can do optimization in checking for the place is safe or not
    // we can use hashMap for that purpose
    public List<List<String>> solveNQueens(int n) {
        // first create a array of character, which has the size of n X n
        // this array will help to place the queens on the board
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        findWays(ans, board, n, 0);

        return ans;
    }

    private void findWays(List<List<String>> ans, char[][] board, int n, int col){
        // we have to find the ways to place the queen in cols manner
        if(col >= n){
            List<String> list = new ArrayList<>();
            addSolution(ans, list, board);
            ans.add(list);
            return;
        }

        // there will be n ways to place the queen from first row
        for(int i = 0; i < n; i++){
            if(isSafe(board, i, col)){
                // place the queen
                board[i][col] = 'Q';
                findWays(ans, board, n, col + 1);
                board[i][col] = '.'; // backtrack
            }
        }
    }


    private void addSolution(List<List<String>> ans, List<String> solution, char[][] board){
        for(char[] row: board){
            StringBuilder str = new StringBuilder();
            for(char ch: row){
                if(ch == 'Q'){
                    str.append("Q");
                }else{
                    str.append(".");
                }
            }
            solution.add(str.toString());
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        int duplicateRow = row;
        int duplicateCol = col;
        // first check there is any col with queen already placed
        for(int c = 0; c <= col; c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        // check for the upper diagonal
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        // check for the lower diagonal
        row = duplicateRow;
        col = duplicateCol;
        while (row < board.length && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        // if none of the condition returns the false, it means queen is safe to place
        return true;
    }
}



// most optimized solution
class Solution {
    public List<List<String>> solveNQueens(int n) {
        // Initialize the board with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] leftRow = new int[n];
        findWays(ans, board, leftRow, lowerDiagonal, upperDiagonal, n, 0);

        return ans;
    }

    private void findWays(List<List<String>> ans, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, int n, int col) {
        if (col >= n) {
            List<String> list = new ArrayList<>();
            addSolution(list, board);
            ans.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            // Check if it's safe to place the queen at board[i][col]
            if (leftRow[i] == 0 && lowerDiagonal[i + col] == 0 && upperDiagonal[n - 1 + col - i] == 0) {
                // Place the queen
                board[i][col] = 'Q';
                leftRow[i] = 1;
                lowerDiagonal[i + col] = 1;
                upperDiagonal[n - 1 + col - i] = 1;

                // Recur to place the rest of the queens
                findWays(ans, board, leftRow, lowerDiagonal, upperDiagonal, n, col + 1);

                // Backtrack: remove the queen and mark the positions as free
                board[i][col] = '.';
                leftRow[i] = 0;
                lowerDiagonal[i + col] = 0;
                upperDiagonal[n - 1 + col - i] = 0;
            }
        }
    }

    private void addSolution(List<String> solution, char[][] board) {
        for (char[] row : board) {
            solution.add(new String(row));
        }
    }
}
