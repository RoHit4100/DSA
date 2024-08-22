package Strivers.ArraysQuestions;

import java.util.ArrayList;
import java.util.List;

public class SetMatrix0s {
    // optimal solution
    public static void setZeroesOptimal(int[][] matrix){
        // in better solution we were taking two arrays for checking which row and col has to convert into zero
        // so in optimal solution we will try not to use those arrays
        // instead,
        // int[] col = matrix[0][..]
        // int[] row = matrix[..][0]
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        // now iterate through matrix and change the inplace rows and cols that we have considered
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // we have to check if any block has zero
                if(matrix[i][j] == 0){
                    // mark the jth col
                    matrix[1][j] = 0;
                    // this condition will only trigger when we are present at the first block of the matrix, and that block will
                    // be common for our considers rows and cols, so to avoid that we will create one col0 variable and store the 0 into that

                    if(j == 0) {
                        col0 = 0;
                    }
                    // mark the ith row
                    matrix[i][0] = 0;
                }
            }
        }


        // now everything has been marked
        // now ignore the cols and rows that we have considered to not alter the resultant array
        // so that's why iterated from index 1 or end index
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                // now check if their any conversion exist or not
                if(matrix[i][j] != 0){
                    // check for col and row
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // now first mark the cols that we have considered as zero, which be except 0th col
        // the entire cols value will be dependent on cols value, if it is marked 0 then just marks all the content in the row as zero
        if(col0 == 0){
            // then mark all the considered row as zero
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }

        // now if first block is marked 0 then all the cols we have considered will become zero
        if(matrix[0][0] == 0){
            for(int i = 0; i < m; i++){
                matrix[0][i] = 0;
            }
        }
    }



    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        // now traverse through whole array and store indexes of 0 in pair
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    pairs.add(p);
                }
            }
        }

        // now we have the list containing zeros, now we will just replace all the rows and col with zeros
        for(Pair<Integer, Integer> p: pairs){
            int row = p.getRow();
            int col = p.getCol();
            for(int i = 0; i < m; i++){
                matrix[row][i] = 0;
            }

            for(int i = 0; i < n; i++){
                matrix[i][col] = 0;
            }
        }
    }

    class Pair<R, C>{
        private R row;
        private C col;

        Pair(R row, C col){
            this.row = row;
            this.col = col;
        }

        R getRow(){
            return this.row;
        }

        C getCol(){
            return this.col;
        }
    }





    // better solution than mine
    public void setZeroesBetter(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0){
            return;
        }
        // now instead of pair class we can use two arrays, one for row and one for col
        int[] rows = new int[n];
        int[] cols = new int[m]; // this two arrays will take care of the which row and col has to convert into zero
        // System.out.println(Arrays.toString(cols));
        // first traverse through whole array and mark that row and col as 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    // here we will mark the current location as 1
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        // now again traverse and convert that block into zero if any one of row and col is 1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rows[i] == 1 || cols[j] == 1){
                    // change into zero
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
