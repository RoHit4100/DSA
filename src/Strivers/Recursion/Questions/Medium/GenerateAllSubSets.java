package Strivers.Recursion.Questions.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>(); // this will store each the current subset in recursion
        generate(ans, nums, 0, subset); // recursion call with index and subset
        return ans;
    }

    private void generate(List<List<Integer>> ans, int[] arr, int index, List<Integer> subset){
        if(index == arr.length){
            // create new list and add into answer
            ans.add(new ArrayList<>(subset));
            return;
        }

        // first take the current index number
        subset.add(arr[index]);
        generate(ans, arr, index + 1, subset);

        // remove the last taken number
        subset.remove(subset.size() - 1);
        generate(ans, arr, index + 1, subset);
    }
}
