package Strivers.StacksAndQueues.Hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    // this will be the brute force solution
    public int largestRectangleArea(int[] heights) {
        // lets just find the prev smaller and next smaller for current index
        int[] prevSmaller = findPrevSmaller(heights); // get the prev smaller
        int[] nextSmaller = findNextSmaller(heights); // get the next smaller

        // now I have prev and next smaller index for any index
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int left = prevSmaller[i]; // the left side till I can go to count the area with be the location of the prev smaller
            int right = nextSmaller[i]; // the right side till I can go to count the area will be the location of the next smaller
            int area = heights[i] * (right - left - 1); // are will the height of the current index * the difference between the right and left
            maxArea = Math.max(maxArea, area); // save the maxArea
        }
        return maxArea;
    }

    private int[] findPrevSmaller(int[] arr){
        int[] pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }


    private int[] findNextSmaller(int[] arr){
        int[] nse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        int n = arr.length;
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }

        return nse;
    }

    // optimal solution using thinking
    public int largestRectangleAreaOptimal(int[] heights) {
        // to optimize this problem I am not allowed to find the next smaller element and prev smaller element
        // in pre computation

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){ // traverse thought each element
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                // If I am here, means the element present at the top of the stack, is greater than me
                // so I can surely say that this current element is the smallest next element for me, which is peek of the stack
                // so I can put the formula to calculate the area of the rectangle
                // which is, arr[i] * (nse - pse - 1)
                int element = heights[stack.pop()]; // this is the element for we have found the next smaller height
                // and the prev smaller height will be the top of the stack now
                // and if there is not prev smaller element, means that element has no prev smaller elements
                // so we can consider the prev smaller will be present at the -1th index
                int prevSmaller = stack.isEmpty() ? -1: stack.peek();

                // and the next smaller will be the current index
                int nextSmaller = i;
                int area = element * (nextSmaller - prevSmaller - 1);

                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        int n = heights.length;
        // in the end, if stack has any elements then find the area for the same as well
        // if stack has any elements this means that for those elements there is no next smaller found
        // and there is not prev smaller found for the same as well
        while(!stack.isEmpty()){
            // the next smaller will be the size of the array definitely, as we have found the next smaller for those indexes
            int nextSmaller = n; // the next smaller for that element will be the length of the array
            int element = heights[stack.pop()]; // getting the element
            int prevSmaller = stack.isEmpty() ? -1: stack.peek(); // getting the prev smaller

            int area = element * (nextSmaller - prevSmaller - 1); // using the formula
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
