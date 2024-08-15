package Strivers.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrWithSumK {
    static int lengthOfSubArraySW2(int[] arr, int k) {
        int sum = 0; // Start sum at 0
        int maxLength = 0; // for storing maxLength
        int left = 0; // this will the stable index, which will only move when sum will exceed the k

        for (int right = 0; right < arr.length; right++) {
            // Add the current element to the sum
            sum += arr[right];

            // If sum exceeds k, move the left pointer to reduce the sum
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            // Check if the current sum equals k and update maxLength if needed
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
    // using sliding window approach but this code will not work with negatives
    static int lengthOfSubArraySW(int[] arr, int k){
        // here we don't have to take any space for solving the problem
        int sum = arr[0]; // this variable will take care of the sum, and make sure that we don't exceed k
        int maxLength = 0; // for storing maxLength
        int left = 0; // this will the stable index, which will only move when sum will exceed the k
        int right = 0;

        while (right < arr.length){
            // first we will check is my current sum greater than the k, and lower than the index, which is the pointer will move when sum exceed the value of k
            // we will run this loop until sum is lower than the k
            while (left <= right && sum > k){
                sum -= arr[left];
                // make sure u increase the index pointer
                left++;
            }
            if(sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
            if(right < arr.length) {
                sum += arr[right];
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        System.out.println(lengthOfSubArray(arr, 15));
    }

    // optimize approach with hashing
    static int lengthOfSubArray(int[] arr, int k){
        // Create a hashMap to store (sum, index) pairs
        Map<Integer, Integer> map = new HashMap<>();
        // Variable to store the maximum length of the sub array
        int maxLength = 0;
        int sum = 0;
        int n = arr.length;
        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Update the sum
            sum += arr[i];
            // Check if the sum is equal to k
            if (sum == k) {
                maxLength = i + 1;
            }

            // Calculate the required value to check in the map
            int targetSum = sum - k;
                // Check if (sum - k) exists in the map
            if (map.containsKey(targetSum)) {
                // Get the index of the required value
                int indexOfKey = map.get(targetSum);
                // Calculate the length of the sub array
                int length = i - indexOfKey;
                // Update the maxLength
                maxLength = Math.max(length, maxLength);
            }

            // Add the current sum to the map if it's not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    // this is the brute force approach with O(n2) complexity
    static int lenOfSubArray(int[] arr, int k){

        int len = 0;
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum == k){
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}
