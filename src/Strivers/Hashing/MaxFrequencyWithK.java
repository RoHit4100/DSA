package Strivers.Hashing;

import java.util.Arrays;

public class MaxFrequencyWithK {
    public int maxFrequency(int[] nums, int k) {
        // Sort the array so that we can work with increasing numbers.
        Arrays.sort(nums);

        // Initialize two pointers for the sliding window approach.
        int left = 0, right = 0;

        // Use 'long' to avoid overflow for the sum of array values in case of large integers.
        long sum = 0;

        // This will store the maximum length of the window where all elements can be made equal.
        int maxLength = 0;

        // Iterate through the array with the 'right' pointer, expanding the window.
        while (right < nums.length) {
            // Add the current number to the sum.
            sum += nums[right];

            // While the cost of making all elements between left and right equal to nums[right]
            // exceeds the allowed operations (k), shrink the window from the left.
            // The condition: nums[right] * (right - left + 1) gives the ideal sum if all elements were nums[right].
            // If the actual sum (stored in 'sum') exceeds this by more than k, we shrink the window.
            while (nums[right] * (right - left + 1L) - sum > k) {
                // Subtract the element at 'left' from the sum and move 'left' forward to shrink the window.
                sum -= nums[left];
                left++;
            }

            // Update the maximum length of the window where all elements are equal.
            maxLength = Math.max(maxLength, right - left + 1);

            // Move the 'right' pointer to expand the window.
            right++;
        }

        // Return the maximum length found.
        return maxLength;
    }
}
