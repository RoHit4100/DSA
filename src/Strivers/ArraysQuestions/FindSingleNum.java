package Strivers.ArraysQuestions;

public class FindSingleNum {

    // this is the optimal approach, brute force approach will be using hashing or frequency array.
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num: nums){
            ans ^= num;
        }
        return ans;
    }
}
