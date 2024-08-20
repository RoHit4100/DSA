package Strivers.Arrays;

import java.util.ArrayList;

public class FlipTheImage {
    public void rotate(int[][] matrix) {
        // to solve this question we just had to find the transpose of the given matrix
        // and after that reverse that transposed matrix

        // to find transposed we know we have to swap the two blocks
        // eg. arr[i][j] swap with arr[j][i]
        int n = matrix.length;
        int m = matrix[0].length;
        // first find the transpose
        for(int i = 0; i < n; i++){
            for(int j = i; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // now we have found the transposed
        // now its time for reversing the each matrix row
        for(int i = 0; i < n; i++){
            // now we have to run inner loop till m/2
            for(int j = 0; j < n / 2; j++){
                // now swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = temp;
            }
        }
    }



    // rotate matrix clockwise
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // We will rotate layer by layer, starting from the outermost one
        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        while (top < bottom && left < right) {
            // Save the top left element as a starting point
            int prev = mat.get(top + 1).get(left);

            // Move elements of top row one step right
            for (int i = left; i <= right; i++) {
                int temp = mat.get(top).get(i);
                mat.get(top).set(i, prev);
                prev = temp;
            }
            top++;

            // Move elements of right column one step down
            for (int i = top; i <= bottom; i++) {
                int temp = mat.get(i).get(right);
                mat.get(i).set(right, prev);
                prev = temp;
            }
            right--;

            // Move elements of bottom row one step left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    int temp = mat.get(bottom).get(i);
                    mat.get(bottom).set(i, prev);
                    prev = temp;
                }
                bottom--;
            }

            // Move elements of left column one step up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    int temp = mat.get(i).get(left);
                    mat.get(i).set(left, prev);
                    prev = temp;
                }
                left++;
            }
        }
    }
}
