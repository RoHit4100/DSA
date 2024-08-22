package Strivers.BinarySearchQuestions.Medium;

public class ReturnTheCountOfOccurance {
    // optimal approach
    int count(int[] arr, int n, int x) {
        // code here
        // first search on the left side of the array
        int firstOccurance = binarySearch(arr, x, true);
        if(firstOccurance < 0 || firstOccurance > n){
            return 0;
        }
        int lastOccurance = binarySearch(arr, x, false);

        return lastOccurance - firstOccurance + 1;
    }

    static int binarySearch(int[] arr, int x, boolean searchLeft){
        int ans = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == x){
                ans = mid; // that can be the first occurance
                if(searchLeft){
                    end = mid - 1; // search on the left side of the array
                }else{
                    start = mid + 1; // search on the right side of the array
                }
            }else if(arr[mid] < x){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}
