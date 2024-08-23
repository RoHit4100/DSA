package Strivers.BinarySearchQuestions.Medium;

public class FindHowManyTimesArrayIsRotated {
    // here we can find out the min of the rotated array, and the index of that min is the actual ans

    static int findHowManyTimesArrayIsRotated(int[] arr){
        int minIndex = 0;
        // we can actually use the same logic as we had used in finding the min of the rotated array
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;

            // check if the current checking space is already sorted or not
            if(arr[start] < arr[end]){
                return start;
            }else if(arr[start] <= arr[mid]){ // check if left part is sorted or not
                if(arr[start] < arr[minIndex]){
                    minIndex = start;
                }
                // now check in the right part
                start = mid + 1;
            }else{ // this means right part is sorted
                if(arr[mid] < arr[minIndex]){
                    minIndex = mid;
                }
                // check in the left part of the array
                end = mid - 1;
            }
        }

        return minIndex;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(findHowManyTimesArrayIsRotated(arr));
        System.out.println(findRotatedBruteForce(arr));
    }

    // brute force approach will be linear search which checks the next element of the index, if that element is greater than the next element then the
    // answer will be index of the next element
    static int findRotatedBruteForce(int[] arr){
        // to eliminate the edge cases left first check if the next element of the first and previous of the last index
        // first check the length of the array
        int n = arr.length;
        if(n == 1){
            return 0;
        }
        // check for the first index
        if(arr[0] > arr[1]){
            return 1;
        }
        // check for the last index
        if(arr[n - 1] < arr[n - 2]){
            return n - 1;
        }

        // now check for the rest of the array
        for(int i = 1; i < n - 1; i++){
            if(arr[i] > arr[i + 1]){
                return i+1;
            }
        }
        return 0;
    }
}
