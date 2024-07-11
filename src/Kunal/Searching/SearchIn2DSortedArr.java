
import java.util.Arrays;

class SearchIn2DSortedArr{
    public static void main(String[] args) {
        int[][] arr = {
            { 1, 2, 3, 4},
            {5, 6, 7, 8}, 
            {9, 10, 11, 12}
        };

        int target = 11;
        System.out.println("Index for " + target + " is:" + Arrays.toString(search(arr, target)));
    }


    static int[] search(int[][] arr, int target){
        int row = 0;
        int col = arr.length - 1;
        

        // this is code for row and col wise sorting algorithm
        while(row < arr.length && col >= 0){
            // here we will check whether or not current element is lower or greater than the target element and adjust the arr according to that
            if(arr[row][col] == target){
                return new int[]{row, col};
            }else if(arr[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}