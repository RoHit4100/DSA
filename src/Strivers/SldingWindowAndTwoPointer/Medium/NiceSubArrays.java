package Strivers.SldingWindowAndTwoPointer.Medium;

public class NiceSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int first = slidingWindow(nums, k);
        int second = slidingWindow(nums, k - 1);
        return first - second;
    }

    private int slidingWindow(int[] arr, int k){
        if(k < 0){
            return 0;
        }

        int left = 0, right = 0;
        int sum = 0, count = 0;

        while(right < arr.length){
            sum += (arr[right] % 2); // if current element is odd then 1 will be added, and if even then 0;
            while(sum > k && left < right){
                sum -= (arr[left] % 2);
                left++;
            }

            if(sum <= k){
                count += (right - left + 1);
            }
            right++;
        }

        return count;
    }
}
