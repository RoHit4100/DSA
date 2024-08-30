package Strivers.Recursion.Questions.Medium;

import java.util.HashMap;

public class CheckIfSubsetExistWithSumK {
    public static boolean isSubsetPresent(int n, int k, int[] arr) {
        // Write your code here
        return helper(arr, k, 0, 0);
    }

    private static boolean helper(int[] arr, int k, int index, int sum){
        if(index == arr.length || sum == k){
            return sum == k;
        }

        // take it
        sum += arr[index];
        boolean check = helper(arr, k, index + 1, sum);
        if(check){
            return true;
        }

        // dont take
        sum -= arr[index];
        return helper(arr, k, index + 1, sum);
    }
}
