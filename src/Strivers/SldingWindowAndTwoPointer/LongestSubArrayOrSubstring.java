package Strivers.SldingWindowAndTwoPointer;

public class LongestSubArrayOrSubstring {
    // this is the most popular pattern, where problem statement includes finding the longest length of the sub array or sub string
    // e.g. find the length of the longest sub array having sum <= 14
    // this method known as two pointer and sliding window method
    static int findMaxLengthOfSubArray(int[] arr, int k){
        // take to pointer known as left and right
        int l = 0, r = 0;
        int maxLength = 0, sum = 0;

        // now we can run loop till right pointer gets out of bound, as we are moving right pointer in most of the cases
        while(r < arr.length){
            sum += arr[r];
            // if sum exceeds the k, then remove the left pointer till sum becomes less the than k
            while(sum > k && l < r){
                sum -= arr[l]; // reduce the sum, with element present at the left pointer location
                l++; // increase the left pointer
            }
            // now we surely know that the range of the left and right is valid
            int length = r - l + 1;
            maxLength = Math.max(length, maxLength);
            // now move right by 1;
            r += 1;
        }

        return maxLength;
    }


    // now the optimal approach to solve this problem will be using sliding window method, and reducing the time we were taking to move left pointer
    static int maxLengthOfSubArray(int[] arr, int k){
        // take two pointers
        int left = 0, right = 0; // both pointer will start from the first element of the array, and only right pointer will move till
        // the given condition gets violated
        int maxLength = 0, sum = 0;

        while(right < arr.length){
            // add the right pointer element into the sum
            sum += arr[right];
            // now check if the sum is exceeding k, if yes then remove the left element from the window
            if(sum > k){
                sum -= arr[left];
                left++;
            }

            // now we will know that the max window size will be constant till we are met to above condition
            if(sum <= k){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            // move right by one, in any condition
            right++;
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,1,7,10};
        System.out.println(findMaxLengthOfSubArray(arr, 14));
        System.out.println(maxLengthOfSubArray(arr, 14));
    }
}
