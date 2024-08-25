package Strivers.BinarySearchQuestions.BSOn1D.Medium;

public class FindPeakElement {
    // optimal solution will use the binary search
    static int findPeakIndex(int[] arr, int n){
        // first eliminate the extra checks for index out of bound
        if(n == 1){
            return 0;
        }
        // check for first index, if first element is greater than the next element
        if(arr[0] > arr[1]){
            return 0;
        }
        // check for the last index
        if(arr[n - 1] > arr[n - 2]){
            return n - 1;
        }

        // start BS
        int start = 1, end = n - 2;
        while (start <= end){
            int mid = start + (end - start) / 2;

            // now check if the current index which is mid, is our ans or not
            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
                return mid;
            }

            // now check if we are on the increasing curve or not
            if(arr[mid] > arr[mid - 1]){ // means we are on increasing curve
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 8, 1, 5, 3};
        System.out.println(findPeakIndex(arr));
        System.out.println(findPeakIndex(arr, arr.length));
    }

    // brute force approach
    // simple linear search
    static int findPeakIndex(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            // check if the current number is greater than its previous and next element
            // take the index out of bound condition
            if((i == 0 || arr[i] > arr[i - 1]) && (i == n - 1 || arr[i] > arr[i + 1])){
                return i;
            }
        }
        return -1;
    }
}
