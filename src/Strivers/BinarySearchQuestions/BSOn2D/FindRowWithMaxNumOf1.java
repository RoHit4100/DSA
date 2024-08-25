package Strivers.BinarySearchQuestions.BSOn2D;

public class FindRowWithMaxNumOf1 {
    // this is the most optimized solution for a matrix with sorted 0 and 1s
    public int rowWithMax1s(int[][] arr) {
        // code here
        int col = arr[0].length - 1;
        int row = 0;
        int ans = -1;
        while (col >= 0 && row < arr.length){
            if(arr[row][col] == 1){
                col--;
                ans = row;
            }else{
                row++;
            }
        }
        return ans;
    }

    // brute force approach
    // this approach will be finding with linear search row, which contains the max number of 1's
}
