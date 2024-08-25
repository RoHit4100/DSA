package Strivers.BinarySearchQuestions.BSOn2D;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchIn2DMatrix {
    // brute force can be simple linear search
    // optimal solution will be using the fact that matrix is sorted
    static boolean searchMatrixOptimal(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        int col = mat.get(0).size() - 1;
        int row = 0;

        while (col >= 0 && row < mat.size()){
            if(mat.get(row).get(col) == target){
                return true;
            }else if(mat.get(row).get(col) < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

    // better solution
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        // in this solution can just apply BS on each row
        for(ArrayList<Integer> row: mat){
            int start = row.get(0);
            int rowLength = row.size();
            int end = row.get(rowLength - 1);
            if(target >= start && target <= end){
                return binarySearch(row, target);
            }
        }
        return false;
    }

    static boolean binarySearch(ArrayList<Integer> arr, int target){
        int start = 0;
        int end = arr.size() - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;

            if(arr.get(mid) == target){
                return true;
            }else if(arr.get(mid) < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
