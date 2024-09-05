package Strivers.StacksAndQueues.Hard;

import java.util.Stack;

public class MaximalRectangle {
    // this sum will use the concept of largest rectangle in histogram
    public int maximalRectangle(char[][] matrix) {
        // first convert this matrix into the histogram for each row, storing the length of the num of ones
        // for that we use the prefix sum
        int n = matrix.length, m = matrix[0].length;
        int[][] arr = new int[n][m];

        // now convert this array into histogram using prefix sum
        for(int col = 0; col < m; col++){ // to convert we will traverse row wise for each col
            int sum = 0;
            for(int row = 0; row < n; row++){
                sum += matrix[row][col] - '0';
                if(matrix[row][col] == '0') sum = 0;
                arr[row][col] = sum;
            }
        }

        // now we have converted the given matrix into the histogram, each col for that row, will have the height of the
        // sum of the ones, which is the height of that bar
        // now pass the row, to the function to calculate the max area of the rectangle
        int maxArea = 0;
        for(int[] histogram: arr){
            // the function will return the max area
            int area = getLargestRectangle(histogram);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    private int getLargestRectangle(int[] heights){
        // we use the most optimal approach
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                // if greater than that means the current element is next smaller of the peek
                int element = heights[stack.pop()];
                int nextSmaller = i;
                int prevSmaller = stack.isEmpty() ? -1 : stack.peek();

                int area = element * (nextSmaller - prevSmaller - 1);
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        int n = heights.length;
        // if any element has left in the stack that means, that element has not next smaller element
        while(!stack.isEmpty()){
            int nextSmaller = n; // the next element will be the size of the array
            int element = heights[stack.pop()]; // element will be the number height present at that index
            int prevSmaller = stack.isEmpty() ? -1: stack.peek();

            int area = element * (nextSmaller - prevSmaller - 1); // this will be the formula, for calculating the area of the rectangle
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
