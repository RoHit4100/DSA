package Strivers.BinaryTrees.Hard;

import Strivers.BinaryTrees.CodingNinjas;

public class MaximumPathSum extends CodingNinjas {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0; // return 0 if root is null

        int[] maxSum = new int[1]; // this will store the maxSum
        maxSum[0] = Integer.MIN_VALUE; // initialize the maxSum as min value
        helper(root, maxSum);
        return maxSum[0]; // return the maxSum
    }

    private int helper(TreeNode root, int[] maxSum){
        if(root == null) return 0; // return 0 if root has become null

        int left = helper(root.left, maxSum); // get the sum from left side
        int right = helper(root.right, maxSum); // get the sum from right side
        // override negative values by 0, for left and right
        left = Math.max(0, left);
        right = Math.max(0, right);
        // calculate the current path sum
        int sum = root.data + left + right;
        maxSum[0] = Math.max(sum, maxSum[0]); // update maxSum if current sum is greater than the maxSum

        return Math.max(left, right) + root.data; // return the maxSum from the left or right side, whichever side has the maxSum return that to its above call
    }
}
