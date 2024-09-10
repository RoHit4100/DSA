package Strivers.GreedyAlgorithms.Medium;

public class JumpGame {
    public boolean canJump(int[] arr) { // this will be the optimal solution for this problem
        int maxJump = 0; // this will select the maximum jump we can have from particular index
        for(int i = 0; i < arr.length; i++){ // iterate through given array
            if(maxJump < i){ // check if we can to reach at current index or not
                return false; // if not possible to current index, return false
            }else if(maxJump >= arr.length - 1){ // check if maxJump we can take is greater than or equal to the end of the array
                return true; // if greater than then return true
            }
            maxJump = Math.max(maxJump, i + arr[i]); // update the maxJump
        }

        return true;
    }
}
