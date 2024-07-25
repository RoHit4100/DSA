

class Nnights{
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        placeNights(board, 0, 0, 4);
    }

    static void placeNights(boolean[][] board, int row, int col, int nights){
        if(nights == 0){
            display(board);
            System.out.println();
        }

        if(row == board.length - 1 && col == board.length){
            return;
        }

        if(col == board.length){
            placeNights(board, row + 1, 0, nights);
            return;
        }

        if(isSafe(board, row, col)){
            board[row][col] = true;
            placeNights(board, row, col + 1, nights - 1);
            board[row][col] = false;
        }

        placeNights(board, row, col + 1, nights);
    }


    static boolean isSafe(boolean[][] board, int row, int col){
        if(isValid(board, row - 2, col - 1)){
            if(board[row - 2][col - 1]){
                return false;
            }
        }

        if(isValid(board, row - 2, col + 1)){
            if(board[row - 2][col + 1]){
                return false;
            }
        }

        if(isValid(board, row - 1, col - 2)){
            if(board[row - 1][col - 2]){
                return false;
            }
        }

        if(isValid(board, row - 1, col + 2)){
            if(board[row - 1][col + 2]){
                return false;
            }
        }

        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0 && col < board.length && row < board.length && col >= 0){
            return true;
        }
        return false;
    }

    static void display(boolean[][] board){
        for(boolean[] arr: board){
            for(boolean element: arr){
                if(element){
                    System.out.print("K ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}