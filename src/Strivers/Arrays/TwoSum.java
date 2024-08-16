package Strivers.Arrays;
import java.awt.desktop.AboutHandler;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    // most optimal approach when array is sorted
    static int[] twoSumSorted(int[] arr, int target){
        // here we use two pointers method one from the beginning of the array, and one from the end of the array
        int end = arr.length - 1;
        int start = 0;
        while (start <= end){
            int sum = arr[start] + arr[end];
            // check sum is equal to target or not
            if(sum == target){
                return new int[] {start, end};
            }else if(sum > target){ // if sum is greater than the target that means I have to decrease my end pointer as array is sorted
                end--;
            }else{ // or if sum is less than the target than means I have to increase the start by 1
                start++;
            }
        }
        return new int[]{-1};
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,8,11};
//        System.out.println(twoSum(arr, 11));
        System.out.println(Arrays.toString(twoSumSorted(arr, 14)));
    }

    // brute force approach
    static boolean twoSum(int[] arr, int k){

        // I will check each addition of each number with the rest of the elements present in the array
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                // this line will check if sum of two number is present in the array or not
                if(arr[i] + arr[j] == k){
                    return true;
                }
            }
        }
        return false;
    }

    // for better solution I will use hashing
    static int[] twoSumHashing(int[] arr, int k){
        // create a hashmap for storing the elements of the array, here we will traverse through array only one's
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int requireNum = k - arr[i];
            if(map.containsKey(requireNum)){
                int indexOfKey = map.get(requireNum);
                return new int[]{indexOfKey, i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1};
    }
}
