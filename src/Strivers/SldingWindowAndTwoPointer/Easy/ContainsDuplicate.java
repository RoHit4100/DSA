package Strivers.SldingWindowAndTwoPointer.Easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // better approach will be using set
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            // use set to solve this question
            Set<Integer> set = new HashSet<>();
            int right = 0;

            while(right < nums.length){
                if(!set.add(nums[right])){ // if set.add return false, means element was previously present in the set
                    return true;
                }
                right++;
            }
            return false;
        }
    }
}
