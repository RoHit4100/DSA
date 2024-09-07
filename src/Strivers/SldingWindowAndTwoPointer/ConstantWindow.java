package Strivers.SldingWindowAndTwoPointer;

public class ConstantWindow {
    // In this pattern window size is constant, and moving
    // e.g. finding the max sum, by picking k elements consecutively from the array
    static int maxSumOfKElements(int[] arr, int k){
        // k will be the window size,
        // to ease up this approach first we can find the sum of the array, till k starting from 0
        int maxSum = 0;
        int right = k; // this will start from k - 1;
        for(int i = 0; i < k; i++){
            maxSum += arr[i];
            right = i;
        }
        // this will give the max sum till k elements, now for further search I can remove the first element, from the sum and add the next item
        int left = 0; // this will start from the first index
        int sum = maxSum;
        // now run loop till right gets out of bound
        while(right < arr.length){
            sum -= arr[left]; // remove the first element from the sum
            // move left ahead by 1
            left++;
            // move right by one, before that add the right element into the sum
            sum += arr[right];
            right++;
            // compare with max sum
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-1,2,3,3,9,5,-1};
        System.out.println(maxSumOfKElements(arr, 4));
    }
}
