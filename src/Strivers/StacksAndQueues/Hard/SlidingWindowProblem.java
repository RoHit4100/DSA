package Strivers.StacksAndQueues.Hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowProblem {
    // brute force solution
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i++){
            // window will be of 3 size
            int max = nums[i];
            for(int j = i; j < k + i; j++){
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }


    // optimal solution will use the deque
    public int[] maxSlidingWindowOptimal(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1]; // the size of the answer will be n - k + 1
        int index = 0; // maintain the index for storing the answer
        // optimal approach will use the deque
        Deque<Integer> stack = new LinkedList<>(); // initialize the stack

        for(int i = 0; i < nums.length; i++){
            // check if the front of the stack, is out of the window or not,
            // when index is 4, for k = 3, then, 4 - 3, means 1st index will be the out of the window, so kick that index out of the stack
            if(!stack.isEmpty() && stack.peekFirst() == i - k){
                // if they are not in my current window pop them out from the front
                stack.pollFirst(); // remove from the front
            }
            // remove the elements from the stack
            while(!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]){  // now poll all the elements which are less than the current element
                stack.pollLast(); // take them out from the end
            }
            stack.offerLast(i); // add the items from the back
            if(i >= k - 1){ // we will stack adding the to answer after reaching the position of k - 1
                ans[index] = nums[stack.getFirst()]; // add the first item of the stack
                index++; // increase the index
            }
        }

        return ans; // return the answer
    }
}
