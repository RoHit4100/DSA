

class NQueen{
    public static void main(String[] args){
        boolean[][] board = new boolean[4][4];
        System.out.println(findAllWays(board, 0));
        
    }


    static int findAllWays(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println("");
            return 1;
        }

        int count = 0;
        for(int col = 0; col < board.length; col++){
            // place the quick if that location is safe
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += findAllWays(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        // to check queen is present vertically or not 
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }


        // to check diagonally we have to check both left and right for the placing of the queen
        // first we have to check in the left, 
        int maxLeft = Math.min(row, col);
        int maxRight = Math.min(row, board.length - col - 1);

        for(int i = 1; i <= maxLeft; i++){
            if(board[row - i][col - i]){
                return false;
            }
        }

        for(int i = 1; i <= maxRight; i++){
            if(board[row - i][col + i]){
                return false;
            }
        }
        return true;
    }

    static void display(boolean[][] board){
        for(boolean[] arr: board){
            for(boolean element: arr){
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}