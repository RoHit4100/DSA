package Strivers.SldingWindowAndTwoPointer.Medium;

public class BinarySubArraySum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int first = slidingWindow(nums, goal); // get the count of the sub array for at most goal as the sum
        int second = slidingWindow(nums, goal - 1); // get the count of the sub arrays for the at most goal - 1 sum
        return first - second; // remove the goal - 1, which will give the answer of at least goal as the sum
    }

    private int slidingWindow(int[] arr, int k){
        if(k < 0){
            return 0; // if goal is negative then return 0, as array is binary
        }
        int count = 0;
        int sum = 0;
        int left = 0, right = 0;
        while(right < arr.length){
            // add the current item into the sum
            sum += arr[right]; // add the current item into the sum
            while(sum > k && left < right){ // now element present the left location till sum is valid
                sum -= arr[left];
                left++; // increment the left pointer
            }
            if(sum <= k){ // check if sum valid or not
                count += (right - left + 1); // if valid then add the count
            }
            right++;
        }

        // return the count
        return count;
    }


    public int numSubArraysWithSum(int[] nums, int goal) {
        // brute force solution
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum > goal){
                    break;
                }
                if(sum == goal){
                    count += 1;
                }
            }
        }
        return count;
    }
}
