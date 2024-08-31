package Strivers.Recursion.Questions.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // create data structure to keep track of which index you have taken
        boolean[] tracker = new boolean[n]; // this will keep track of which index was taken
        List<Integer> permutation = new ArrayList<>();
        helper(ans, permutation, nums, tracker);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> permutation, int[] arr, boolean[] tracker){
        if(permutation.size() == arr.length){ // whenever permutation size is equal to the length then that will be our permutation
            // add answer and return
            ans.add(new ArrayList<>(permutation));
            return;
        }

        // check each number for each permutation
        for(int i = 0; i < arr.length; i++){ // we will check if the current number is taken or not
            if(!tracker[i]){ // check if current index is taken or not
                permutation.add(arr[i]); // if not taken then take
                tracker[i] = true; // mark as taken
                helper(ans, permutation, arr, tracker); // call for other number
                tracker[i] = false; // whenever comeback, mark as not taken
                permutation.remove(permutation.size() - 1); // remove the last added number
            }
        }
    }


//    optimized solution this will use the swapping to find the permutations
public List<List<Integer>> permuteOptimized(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    helper(ans, nums, 0);  // call to find the permutations
    return ans;
}

    private void helper(List<List<Integer>> ans, int[] arr, int index){
        if(index == arr.length){ // check if index has gone out of bound or not
            List<Integer> list = new ArrayList<>(); // if gone, then just add the current state of array into the answer
            for(int num: arr){
                list.add(num);
            }
            ans.add(list);
            return; // return after adding the permutation
        }

        // swap with each number starting from the index
        for(int i = index; i < arr.length; i++){
            swap(arr, index, i); // swap with the index, and the current location
            helper(ans, arr, index + 1); // call with next index
            swap(arr, index, i); // backtrack, swapping will modify the array, so swap again to original location
        }
    }

    private void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
