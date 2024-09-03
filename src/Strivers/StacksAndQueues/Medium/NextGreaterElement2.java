package Strivers.StacksAndQueues.Medium;

import java.util.Stack;

public class NextGreaterElement2 {
    // Extreme brute force approach
    public int[] nextGreaterElements(int[] arr) {
        int[] nge = new int[arr.length];

        // in this problem the next greater element may lie in left direction and if not there it may lie in right direction
        for(int i = 0; i < arr.length; i++){
            int max = arr[i];
            // first check from i + 1 to n
            for(int j = i + 1; j < arr.length; j++){
                if(max < arr[j]){
                    max = arr[j];
                    break;
                }
            }
            if(max != arr[i]){
                nge[i] = max;
                continue;
            }
            // now check from 0 to i - 1
            for(int j = 0; j < i; j++){
                if(max < arr[j]){
                    max = arr[j];
                    break;
                }
            }
            if(max != arr[i]){
                nge[i] = max;
            }else{
                nge[i] = -1;
            }
        }

        return nge;
    }


    // now using hypothetical array. time complexity will be the same, but we will use the mathematical formula
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];

        // the length of the array is n, and the n elements from the current index will be i + n - 1,
        for(int i = 0; i < n; i++){
            int max = nums[i];
            for(int j = i + 1; j <= i + n - 1; j++){
                int current = j % n;
                if(max < nums[current]){
                    max = nums[current];
                    break;
                }
            }
            if(max == nums[i]){
                nge[i] = -1;
            }else{
                nge[i] = max;
            }
        }
        return nge;
    }



    // now next greater element using monotonic stack and hypothetical index
    public int[] nextGreaterElementsOptimal(int[] nums) {
        // start traversing from the last index of the hypothetical index
        int n = nums.length;
        int hypotheticalIndex = 2 * n - 1; // this will be the hypothetical size of the array, and to find the next greatest element
        // we traverse from the last element of the array
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>(); // this will be our monotonic stack

        for(int i = hypotheticalIndex; i >= 0; i--){ // start from the end of the size
            int index = i % n; // index will be 9 % 5 = 4
            while (!stack.isEmpty() && nums[index] >= stack.peek()){ // remove elements from the stack till current element is greater
                stack.pop();
            }
            if(i < n){ // check if the current index is actual index or not
                nge[i] = !stack.isEmpty() ? stack.peek(): -1;
//                if(stack.isEmpty()){ // if stack is empty then there will be no greater element
//                    nge[i] = -1;
//                }else {
//                    nge[i] = stack.peek(); // if stack is not empty then the top of the stack will be greatest element
//                }
            }
            stack.push(nums[index]); // push the current element into the stack
        }

        return nge;
    }
}
