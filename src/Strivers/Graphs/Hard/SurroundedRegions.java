package Strivers.Graphs.Hard;

public class SurroundedRegions {

    class Solution {
        public void solve(char[][] board) {
            int n = board.length;
            if (n == 0) return;
            int m = board[0].length;

            // Mark all 'O's on the edge and connected to the edge
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && board[i][j] == 'O') {
                        dfs(board, i, j, n, m);
                    }
                }
            }

            // Now convert all remaining 'O's to 'X', and '#' back to 'O'
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int row, int col, int n, int m) {
            // Mark the current 'O' as '#' to indicate it's not surrounded
            board[row][col] = '#';

            int[] dRow = {1, 0, -1, 0};
            int[] dCol = {0, 1, 0, -1};

            // Explore the four directions
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                // If valid and still 'O', continue the DFS
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && board[nRow][nCol] == 'O') {
                    dfs(board, nRow, nCol, n, m);
                }
            }
        }
    }

}
