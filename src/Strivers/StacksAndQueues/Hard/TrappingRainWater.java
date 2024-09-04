package Strivers.StacksAndQueues.Hard;

public class TrappingRainWater {
    // optimized solution
    public int trapWaterOptimized(int[] height){
        // to find the total water we can store in between buildings we have to first find is there any longer building
        // present in the left or right, it means if I am travelling from start I will only need the building
        // from left, which has more height

        // so lets travel from the beginning and the ending at the same time,
        // while maintaining the tallest building we have encounter till that point
        int leftMax = 0, rightMax = 0, total = 0;
        int left = 0, right = height.length -1;

        // now traverse through array till you are at the same point
        while(left < right){
            // now first check if left is smaller than the right
            if(height[left] <= height[right]){
                // now we know that in the right there is absolutely some greater than the current index, means
                // maybe we can store some water here, so check whether we have any greater building on the left side
                // and the building will be smaller than the building present on the right side
                if(height[left] < leftMax){
                    total += leftMax - height[left]; // this means I have someone greater than current building and i can store the water
                    // and the water I can store above current building will be the max height of the left side, and the current height of the building
                }else{
                    leftMax = height[left]; // if there is longer building then current building will be the longer one
                }
                // now move left by 1, because we, know we can potentially find the smaller building ahead, as right side has the longer building
                left = left + 1;
            }else { // this means in the right we have smaller building than the left side
                // now check if the current building is the longer or not
                if(height[right] < rightMax){
                    total += (rightMax - height[right]);
                }else{
                    rightMax = height[right];
                }
                // now move right
                right = right - 1;
            }
        }

        return total;
    }

    // better solution using suffix max and prefix max
    public int trap(int[] height) {
        // to solve this problem there is a good intuition, which will come by observation and the common sense
        int totalWater = 0;
        int[] leftMax = new int[height.length];
        prefixMax(leftMax, height);
        int[] rightMax = new int[height.length];
        suffixMax(rightMax, height);
        for(int i = 0; i < height.length; i++){
            int leftMaxHeight = leftMax[i]; // get the left max for the current location in the left max array
            int rightMaxHeight = rightMax[i]; // get the right max for current index front right max array
            // now first check if my current height is smaller than the right and left height, if smaller than only
            // the current building can store the water
            if(height[i] < leftMaxHeight && height[i] < rightMaxHeight){
                // this means the min of the left and right max height - the current height, that much water we can store
                // on the current building
                totalWater += (Math.min(leftMaxHeight, rightMaxHeight) - height[i]);
            }
        }
        // return the total water
        return totalWater;
    }

    // now first find the left max height, we will use a better approach, by using prefix method
    private void prefixMax(int[] leftMax, int[] height){
        int max = height[0]; // assign first index of the height array as max
        leftMax[0] = max; // first max for the first index will be that index itself
        for(int i = 1; i < height.length; i++){
            if(max < height[i]){ // check if the max is smaller than the current height
                max = height[i]; // if smaller then, update the max
            }
            leftMax[i] = max; // update the left max array
        }
    }

    private void suffixMax(int[] rightMax, int[] height){
        // do the same but this time from the end of the array
        int n = height.length;
        int max = height[n - 1];
        rightMax[n - 1] = max;
        for(int i = n - 2; i >= 0; i--){
            if(max < height[i]){
                max = height[i];
            }
            rightMax[i] = max;
        }
    }



    // by doing some space optimization
    class Solution {
        public int trap(int[] height) {
            // to solve this problem there is a good intuition, which will come by observation and the common sense
            int totalWater = 0;
            int[] rightMax = new int[height.length];
            suffixMax(rightMax, height);
            int leftMaxHeight = Integer.MIN_VALUE;
            for(int i = 0; i < height.length; i++){
                // now first check if my current height is smaller than the right and left height, if smaller then only
                // the current building can store the water
                leftMaxHeight = Math.max(leftMaxHeight, height[i]);
                int rightMaxHeight = rightMax[i];
                if(height[i] < leftMaxHeight && height[i] < rightMaxHeight){
                    // this means the min of the left and right max height - the current height, that much water we can store
                    // on the current building
                    totalWater += (Math.min(leftMaxHeight, rightMaxHeight) - height[i]);
                }
            }

            return totalWater;
        }

        private void suffixMax(int[] rightMax, int[] height){
            int n = height.length;
            int max = height[n - 1];
            rightMax[n - 1] = max;

            for(int i = n - 2; i >= 0; i--){
                if(max < height[i]){
                    max = height[i];
                }
                rightMax[i] = max;
            }
        }
    }

}
