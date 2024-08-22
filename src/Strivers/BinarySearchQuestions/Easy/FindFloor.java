package Strivers.BinarySearchQuestions.Easy;

public class FindFloor {
    static int BS(long arr[], int n, long x) {
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
        return -1;
    }
}
