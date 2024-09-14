package ProblemOfTheDay.LeetCode;

public class LongestSubArrayWithMaxBitwiseAnd {
    public int longestSubArray(int[] nums) {
        int max = Integer.MIN_VALUE; // this will store the current max of the array
        int count = 0, maxLength = 0; // to store the maxLength

        for(int num: nums){ // traverse for each num in nums
            if(max < num){ // check if the current num is greater than the max
                count = 1; // if yes then make count as 1
                maxLength = 1; // make maxLength as 1
                max = num; // update the max
            }else if(max == num){ // check if this num is equal to max or not
                count++; // if yes then increase the count
                maxLength = Math.max(maxLength, count); // update the maxLength
            }else{
                count = 0; // reset the count to zero whenever we find the smaller element, this will help to track the consecutive max length
            }
        }
        return maxLength;
    }
}
