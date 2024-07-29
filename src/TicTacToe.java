import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner sc = new Scanner(System.in);
        // now make all the location blank.
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = ' ';
            }
        }
//        print(board);


        // now its time to take input from the user
        char player = 'X';
        boolean gameOver = false;
        while (!gameOver){
            print(board);
            System.out.print("Player" + player + " enter: " );
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            // now I have to check whether the place user trying to enter value in is empty or not
            if(board[row][col] == ' '){
                board[row][col] = player; // place the value of the player;
                gameOver = hasWon(board, player);
                if(gameOver){
                    System.out.println("Player " + player + " has won");
                    print(board);
                }else{
                    player = (player == 'X') ? 'O' : 'X';
                }
            }else{
                System.out.println("Please enter some valid location");
            }
        }
    }

    public static boolean hasWon(char[][] board, char player){
        // now I have to check in columns, rows and in diagonals that player has won or not
        // for rows
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        // now for cols
        for(int cols = 0; cols < board.length; cols++){
            if(board[0][cols] == player && board[1][cols] == player && board[2][cols] == player){
                return true;
            }
        }

        // now to check diagonally we have to check in both diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }


    public static void print(char[][] board){
        for(char[] row: board){
            System.out.print("| ");
            for (char block: row){
                System.out.print(block + " | ");
            }
            System.out.println();
        }
    }
}
