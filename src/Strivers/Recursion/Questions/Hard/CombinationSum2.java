package Strivers.Recursion.Questions.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> combination, int[] arr, int target, int index) {
        if (target == 0) { // check if target has become zero or not, if then this is one of the answer
            ans.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) { // check for if current element is first index or not, if first then don't
                // check with previous, if not then check if it is similar to previous
                // if yes then just continue
                continue;
            }
            if (target - arr[i] < 0) { // check if current element is valid choice for taking the sum
                break; // if not then just break out of the loop, ans array is sorted
            }

            combination.add(arr[i]); // add current item into combination
            helper(ans, combination, arr, target - arr[i], i + 1); // call with next index, i + 1
            combination.remove(combination.size() - 1); // remove the last added element
        }
    }
}
