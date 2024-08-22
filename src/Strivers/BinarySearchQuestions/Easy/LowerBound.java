package Strivers.BinarySearchQuestions.Easy;

public class LowerBound {
    // lower bound is the smallest index such that that index is greater than or equal to x
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        if(arr[0] == x){
            return 0;
        }
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == x){
                return mid;
            }else if(arr[mid] > x){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
