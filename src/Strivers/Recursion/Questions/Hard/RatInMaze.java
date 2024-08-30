package Strivers.Recursion.Questions.Hard;

import java.util.ArrayList;

public class RatInMaze {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        // check if there is destination present or not, and check if we can start from 0,0
        if(mat[0][0] == 0 || mat[mat.length - 1][mat[0].length - 1] == 0) {
            ans.add("-1");
            return ans;
        }
        helper(ans, mat, 0, 0, new StringBuilder());
        // if no path found then simply return -1
        if (ans.isEmpty()) {
            ans.add("-1");
        }
        return ans;
    }

    private void helper(ArrayList<String> ans, int[][] mat, int row, int col, StringBuilder p) {
        // Base case: if reached the destination, add the path to the list
        if (row == mat.length - 1 && col == mat[0].length - 1) {
            ans.add(p.toString());
            return;
        }

        // check for out of bound conditions
        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || mat[row][col] == 0) {
            return;
        }

        // Mark as visited
        mat[row][col] = 0;

        // Move Down
        p.append("D");
        helper(ans, mat, row + 1, col, p);
        p.deleteCharAt(p.length() - 1);

        // Move Right
        p.append("R");
        helper(ans, mat, row, col + 1, p);
        p.deleteCharAt(p.length() - 1);

        // Move Up
        p.append("U");
        helper(ans, mat, row - 1, col, p);
        p.deleteCharAt(p.length() - 1);

        // Move Left
        p.append("L");
        helper(ans, mat, row, col - 1, p);
        p.deleteCharAt(p.length() - 1);

        // Unmark as visited
        mat[row][col] = 1;
    }
}
