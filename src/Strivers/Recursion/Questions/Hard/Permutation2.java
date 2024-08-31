package Strivers.Recursion.Questions.Hard;

import java.util.*;

public class Permutation2 {
    // this is the brute force solution
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> permutation = new ArrayList<>();

        boolean[] tracker = new boolean[nums.length];

        helper(set, permutation, tracker, nums);
        return new ArrayList<>(set);
    }

    private void helper(Set<List<Integer>> ans, List<Integer> permutation, boolean[] tracker, int[] arr){
        if(permutation.size() == arr.length){
            // add permutation into answer and return
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(tracker[i]){
                continue;
            }
            // take
            permutation.add(arr[i]);
            tracker[i] = true;
            helper(ans, permutation, tracker, arr);
            // backtrack
            permutation.remove(permutation.size() - 1);
            tracker[i] = false;
        }
    }
    public List<List<Integer>> permuteUniqueOptimized(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, nums, 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, int[] arr, int index){
        if(index >= arr.length){
            // add and return
            List<Integer> list = new ArrayList<>();
            for(int num: arr){
                list.add(num);
            }
            ans.add(list);
            return;
        }

        Set<Integer> seen = new HashSet<>(); // To track elements that have already been used at this level
        for(int i = index; i < arr.length; i++){
            if(seen.contains(arr[i])) { // Skip if this element has already been processed at this level
                continue;
            }
            seen.add(arr[i]);

            swap(arr, index, i);
            helper(ans, arr, index + 1);
            swap(arr, index, i); // Backtrack to the previous state
        }
    }


    private void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
