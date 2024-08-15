package Strivers.Arrays;

public class FindMissingNum {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int num: nums){
            ans ^= num;
        }

        for(int i = 0; i <= n; i++){
            ans ^= i;
        }

        return ans;
    }
}
