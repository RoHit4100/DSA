package Strivers.ArraysQuestions;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthOfSubArrayHavingSum0 {
    public static void main(String[] args) {

    }

    // first brute force approach includes finding all sub arrays with time complexity of O(N2)

    // optimal approach includes using hashing
    static int findMaxLength(int[] arr){
        int maxLength = Integer.MIN_VALUE;

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == 0){
                maxLength = i + 1;
            }else if(map.containsKey(sum)){
                int length = map.get(sum);
                maxLength = Math.max(maxLength, i - length);
            }else{
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
