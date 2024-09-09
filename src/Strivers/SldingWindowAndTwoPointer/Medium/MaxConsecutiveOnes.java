package Strivers.SldingWindowAndTwoPointer.Medium;

public class MaxConsecutiveOnes {
    // brute force solution
    public int longestOnes(int[] nums, int k) {
        // brute force approach will check every subSet
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            int zeros = k;  // Initialize zeros count for each new starting point `i`
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0) {
                    zeros--;  // Decrease zeros count if we encounter a zero
                }
                if(zeros < 0) {
                    break;  // If zeros become negative, this sub array is invalid
                }
                // Only update maxLength if the current sub array is valid (zeros >= 0)
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    // better solution
    public int longestOnesOptimalBetter(int[] nums, int k) {
        // let's solve this problem with sliding window approach
        int left = 0, right = 0;
        int zeros = 0;
        int maxLength = 0;
        while(right < nums.length){
            if(nums[right] == 0){ // check if the current element is zero or not
                zeros++;
            }
            while(zeros > k && left < right){ // now run this loop till zeroes are in the range
                // now remove the reduce the zeroes
                if(nums[left] == 0){ // reduce zero only if left element is zero
                    zeros--;
                }
                left++; // move left at any cost
            }

            // now we can count the length
            if(zeros <= k){ // check if zeros are in the range or not
                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
            }
            right++;
        }

        return maxLength;
    }


    // this will be the most optimal solution
    public int longestOnesOptimal(int[] nums, int k) {
        // let's solve this problem with sliding window approach
        int left = 0, right = 0;
        int zeros = 0;
        int maxLength = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                zeros++;
            }
            if(zeros > k){
                // now remove the reduce the zeroes
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }

            // now we can count the length
            if(zeros <= k){
                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
            }
            right++;
        }

        return maxLength;
    }
}
