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
