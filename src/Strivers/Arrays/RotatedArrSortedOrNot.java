package Strivers.Arrays;

public class RotatedArrSortedOrNot {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1]){
                // count the disruptions
                count++;
            }
        }

        // checking if array is rotated or not
        // this will check whether array is rotated or not, if rotated then the first element will always greater than
        // the last element
        if (nums[n - 1] > nums[0]) {
            count++;
        }
        // if more than one time the count is increased then just return false;
        return count <= 1;
    }
}
