package Strivers.SldingWindowAndTwoPointer.Medium;

public class MaximumPointsCard {
    // this will be the most optimal solution for this problem
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // first find the sum till k elements from the beginning
        int leftSum = 0, rightSum = 0; // first initialize the left and right sum pointer, to keep track of left and right sum
        for(int i = 0; i < k; i++){ // now traverse till k - 1 to find the left side of sum
            leftSum += cardPoints[i];
        }
        if(n == k){ // k == length, then return the leftSum, as this sum will be the max
            return leftSum;
        }

        // save the maxSum as leftSum
        int maxSum = leftSum;
        int rightIndex = n - 1; // keep a pointer for last index, to add that element into the right index
        for(int i = k - 1; i >= 0; i--){ // traverse from k - 1 to 0
            leftSum -= cardPoints[i]; // reduce the left sum, by eliminating the k - 1 index element
            rightSum += cardPoints[rightIndex]; // add the last index element into the right sum
            rightIndex--; // reduce the last index
            int total = leftSum + rightSum; // get the sum of right half and left half
            maxSum = Math.max(total, maxSum); // save the max sum
        }
        // return the maxSum;
        return maxSum;
    }
}
