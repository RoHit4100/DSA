package Test.SankeySolutions;

public class RotateMatrix90AntiClock {
    static void rotate(int[][] matrix){
        // Code Here
        // to rotate matrix 90 degrees in anti clock wise direction, first we have to reverse each row of the matrix
        int n = matrix.length;
        for(int[] row: matrix){
            int start = 0, end = n - 1;
            while(start <= end){ // this function will reverse, each row
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;

                start++;
                end--;
            }
        }

        // this below for loop will convert the matrix into transpose matrix
        //  means row will become the col, and col will become the row
        // now convert the matrix into transpose
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
