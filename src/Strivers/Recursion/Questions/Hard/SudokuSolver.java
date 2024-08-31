package Strivers.Recursion.Questions.Hard;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        // first traverse the board, and find the empty place where we can place number
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == ' '){
                    // check if current place is safe to place the number or not
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){ // if safe then place the current character
                            board[i][j] = c;
                            boolean possible = solve(board);
                            if(possible){
                                return true;
                            }
                            board[i][j] = ' ';
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }


    private boolean isValid(char[][] board, int row, int col, char num){
        // first check for the current row
        for(int i = 0; i < board.length; i++){
            // check for the current row
            if(board[i][col] == num){
                return false;
            }
            // check for the current col
            if(board[row][i] == num){
                return false;
            }
            // check for the current box
            int currentRow = (row / 3) + i / 3;
            int currentCol = (col / 3) + i % 3;
            if(board[currentRow][currentCol] == num){
                return false;
            }
        }
        return true;
    }
}
