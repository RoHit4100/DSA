package Strivers.Recursion.Questions.Hard;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        // first go through each and every row and col, if you find the match character then start searching from that character for word
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = word.charAt(0);
                if(ch == board[i][j]){
                    boolean result = search(board, word, i, j, 0);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int index){
        // check if we are at the last index of the word
        if(index == word.length()){
            return true;
        }

        // now check for the out off bound condition.
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        // check if current location is visited, and if current word character is equals to require character
        if(word.charAt(index) != board[row][col] || board[row][col] == '#'){
            return false;
        }
        // mark current location as #, for preventing for again visit
        char ch = board[row][col];
        board[row][col] = '#'; // make changes
        boolean down = search(board, word, row + 1, col, index + 1);
        boolean right = search(board, word, row, col + 1, index + 1);
        boolean up = search(board, word, row - 1, col, index + 1);
        boolean left = search(board, word, row, col - 1, index + 1);

        // backtrack, means undo the changes
        board[row][col] = ch; // undo changes
        return down || right || up || left; // if any one of the sides returns true, then answer is found.
    }
}
