package Strivers.GreedyAlgorithms.Medium;

public class Jump2 {
    // this will be the brute force solution
    public int jump(int[] nums) {
        // using recursion
        return helper(nums, 0, 0);
    }

    private int helper(int[] arr, int index, int jumps){
        if(index >= arr.length - 1){
            return jumps; // if we reached ahead or at the end of the arr then return jumps
        }

        int min = Integer.MAX_VALUE; // take min value, to return the min jump
        for(int i = 1; i <= arr[index]; i++){ // there will be arr[index] jumps for each index
            // recursive calls will be from given index + for each jum which starts from 1JK
            min = Math.min(min, helper(arr, index + i, jumps + 1)); // return the min of the returned jumps
        }
        return min; // return the min jumps
    }


    // now most optimal method using the range
    public int jumpOptimal(int[] nums) {
        // take two pointers, which will act as range for jump, and then find the max jump we can take in that range
        int left = 0, right = 0;
        int jumps = 0; // this will keep track of how much jumps are taken to reach at the end

        while(right < nums.length - 1){ // run this loop till right is 2 places before the end
            int farthest = 0; // this will store the farthest we can go
            // now search through range and find the max jump we can take
            for(int i = left; i <= right; i++){
                farthest = Math.max(farthest, nums[i] + i); // update the farthest
            }
            left = right + 1; // left will be right + 1
            right = farthest; // right will be farthest
            jumps++;
        }

        return jumps;
    }
}
