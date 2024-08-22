package Strivers.ArraysQuestions;

public class SpiralOrderTraversal {
    public static int findKthElement(int[][] matrix, int k) {
        // Write your code here.
        // first check if k is in the bound or not
        int n = matrix.length;
        int m = matrix[0].length;

        if(m * n < k || k <= 0){
            return -1;
        }

        // now assign the top left right down variables for ease
        int top = 0, left = 0, right = m - 1, bottom = n - 1;
        int count = 0;

        // now run a loop till left is always less than the right and top is always less than bottom
        while(top <= bottom && left <= right){
            // for first iteration left to right

            for(int i = left; i <= right; i++){
                count++;
                if(matrix[top][i] == k){
                    return matrix[top][i];
                }
            }
            top++; // after left to right we have to increase the row, means
            // we have to go the next row

            // after left to right, we will perform left to right
            for(int i = top; i <= bottom; i++){
                count++;
                if(count == k){
                    // here we are traversing row wise, therefore row will be i
                    // and col will be the last one or right one
                    return matrix[i][right];
                }
            }
            right--; // decrease one column from the right

            // now traverse from right to left
            // first we check how many rows have remained, if there are no rows
            // then we cant travel in a row
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    count++;
                    if(count == k){
                        return matrix[bottom][i];
                    }
                }
                bottom--;
            }

            // now traverse from bottom to top
            // for this first check are their any cols remained
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    count++;
                    if(count == k){
                        return matrix[i][left];
                    }
                }
                left++;
            }
        }

        return -1;
    }
}
