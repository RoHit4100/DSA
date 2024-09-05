package Strivers.StacksAndQueues.Hard;

import java.util.Stack;

public class SumOfSubRanges {
    // brute force approach
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }

    class Solution {
        public long subArrayRanges(int[] nums) {
            // find the sum of min
            long sumOfMin = findSumOfMin(nums);
            long sumOfMax = findSumOfMax(nums);

            return sumOfMax - sumOfMin;
        }

        private long findSumOfMin(int[] arr){
            int[] nextSmaller = findNextSmaller(arr);
            int[] prevSmaller = findPrevSmaller(arr);

            long sumOfMin = 0;
            for (int i = 0; i < arr.length; i++) {
                // Number of subarrays where arr[i] is the minimum
                int left = i - prevSmaller[i];
                int right = nextSmaller[i] - i;

                // Contribution to the sum
                sumOfMin += (long)left * right * arr[i];
            }

            return sumOfMin;
        }

        private long findSumOfMax(int[] arr){
            int[] nextGreater = findNextGreater(arr);
            int[] prevGreater = findPreviousGreater(arr);

            long sumOfMax = 0;
            for (int i = 0; i < arr.length; i++) {
                // Number of subarrays where arr[i] is the maximum
                int left = i - prevGreater[i];
                int right = nextGreater[i] - i;

                // Contribution to the sum
                sumOfMax += (long)left * right * arr[i];
            }

            return sumOfMax;
        }

        private int[] findPrevSmaller(int[] arr){
            int n = arr.length;
            int[] pse = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }

                pse[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            return pse;
        }

        private int[] findNextSmaller(int[] arr){
            int n = arr.length;
            int[] nse = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }

                nse[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }

            return nse;
        }

        private int[] findPreviousGreater(int[] arr){
            int[] pge = new int[arr.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }

                pge[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            return pge;
        }

        private int[] findNextGreater(int[] arr){
            int n = arr.length;
            int[] nge = new int[arr.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = arr.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    stack.pop();
                }

                nge[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            return nge;
        }
    }

}
