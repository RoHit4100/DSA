package Strivers.StacksAndQueues.Medium;

import java.util.Stack;

public class SumOfSubArrayMin {
    // Brute force solution will be this
    private int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        // brute force approach will be generating all the sub arrays, and finding the min from that sub array
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            int min = arr[i]; // initial min will be the first index of the sub array
            for(int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]); // update the min
                sum = (sum + min) % MOD; // take the sum and mod that sum
            }
        }
        return sum;
    }

    // Function to compute Previous Less Element (PLE) for each element in the array
    private int[] computePLE(int[] arr) {
        int n = arr.length;
        int[] ple = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack until we find an element less than arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element on the left, so distance is i + 1
            // Otherwise, the distance is the difference between the current index and the index of the top element of the stack
            ple[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            // Push the current index onto the stack
            stack.push(i);
        }

        return ple;
    }

    // Function to compute Next Less Element (NLE) for each element in the array
    private int[] computeNLE(int[] arr) {
        int n = arr.length;
        int[] nle = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack until we find an element less than arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element on the right, so distance is n - i
            // Otherwise, the distance is the difference between the index of the top element of the stack and the current index
            nle[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            // Push the current index onto the stack
            stack.push(i);
        }

        return nle;
    }

    // Function to compute the sum of minimums of all subarrays
    public int sumSubarrayMins1(int[] arr) {

        int MOD = 1_000_000_007;
        int n = arr.length;

        // Compute Previous Less Element (PLE) array
        int[] ple = computePLE(arr);

        // Compute Next Less Element (NLE) array
        int[] nle = computeNLE(arr);

        // Calculate the total sum of minimums of all subarrays
        long result = 0;
        for (int i = 0; i < n; i++) {
            // Contribution of arr[i] as the minimum in subarrays
            result = (result + (long) arr[i] * ple[i] * nle[i]) % MOD;
        }

        return (int) result;
    }
}

