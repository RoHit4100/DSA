package Strivers.BinarySearchQuestions.BSOn1D.Medium;

import java.util.Arrays;

public class FirstAndLastOccuranceOfX {
    // there will two optimal approaches
    // first will be finding the upper and lower bound
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        if(arr[0] == x){
            return 0;
        }
        int start = 0;
        int end = n - 1;
        int lowerBound = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] >= x){
                // lower bound is the smallest index such that element at that index is greater than or equal to the x
                lowerBound = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return lowerBound;
    }

    public static int upperBound(int []arr, int n, int x){
        // Write your code here.
        int start = 0;
        int end = n - 1;
        int ans = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > x){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
    static int[] searchRange(int[] arr, int x){
        int lowerBound = lowerBound(arr, arr.length, x);
        if(lowerBound == -1 || arr[lowerBound] != x || lowerBound > arr.length){
            return new int[]{-1,-1};
        }
        // if above condition not executed then find the upper bound
        int upperBound = upperBound(arr, arr.length, x);
        return new int[]{lowerBound, upperBound - 1};
    }

    // second optimal approach will be performing BS after finding the x, first in left side and then in the right side
    static int[] searchForRange(int[] arr, int x){
        // first search on the left side of the array
        int firstOccurance = binarySearch(arr, x, true);
        int lastOccurance = binarySearch(arr, x, false);
        return new int[] {firstOccurance, lastOccurance};
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
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(firstAndLastOccurance(arr, 8)));
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    // first the brute force or naive approach
    // linear search which takes O(n) complexity
    static int[] firstAndLastOccurance(int[] arr, int x){
        int first = -1;
        int last = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x){
                if(first == -1){
                    first = i;
                }
                last = i;
            }
        }

        return new int[] {first, last};
    }
}
