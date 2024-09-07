package Strivers.SldingWindowAndTwoPointer.Easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // this set will make sure only k elements present into the window
        Set<Integer> window = new HashSet<>(); // create hashSet to store the elements
        for(int i = 0 ; i < nums.length; i++) { // move the i for each element in nums
            if(i > k) window.remove(nums[i - k - 1]); // if i becomes greater than k, that means, we have to remove the element present at the i - k - 1 index
            if(!window.add(nums[i])) return true; // if element is already exist in the window return true;
        }

        return false;
    }
}
