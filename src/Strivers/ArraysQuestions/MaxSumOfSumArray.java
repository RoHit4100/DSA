package Strivers.ArraysQuestions;

import java.util.Arrays;

public class MaxSumOfSumArray {
    // optimal approach uses kadane's algorithm, which resets the sum to 0 when sum is less than 0
    // this algorithm will just take O(n) complexity
    static int maxSumKadaneAlgo(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        // now traverse through each element in the array
        for(int num: arr){
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    // this function will just print the sub array having the max sum
    // we know that whenever we are initializing the sum to 0 we are actually starting from the new sub array so we will just store the index from that to
    // the pointer Where I found the change in the maxSum
    static int[] maxSumPrintSubArrayKadaneAlgo(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        // now traverse through each element in the array
        for(int i = 0; i < arr.length; i++){
            // first find the sum
            sum += arr[i];

            // if sum is greater, then update the maxSum
            if(sum > maxSum){
                maxSum= sum;
                // update the answer's start index
                ansStart = start;
                // and make the current index as the end index of the array;
                ansEnd = i;
            }else if(sum < 0){
                sum = 0;
                // update the start, whenever we reset the sum
                start = i;
            }
        }
        // if both index are not updated then just return the empty array
        if(ansStart == -1 || ansEnd == -1){
            return new int[]{};
        }
        return Arrays.copyOfRange(arr, ansStart, ansEnd + 1);
    }

    public static void main(String[] args) {
        int[] arr = {2,-2,2,7,8,0};
        System.out.println(findMaxSumBruteForce(arr));
        System.out.println(maxSumKadaneAlgo(arr));
        System.out.println(Arrays.toString(maxSumPrintSubArrayKadaneAlgo(arr)));
    }


    // this is the brute force approach having complexity of O(n2);
    static int findMaxSumBruteForce(int[] arr){
        // now take a maxSum variable to keep track of MAX sum
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            int sum = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
