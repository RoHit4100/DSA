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
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (target - arr[i] < 0) {
                break;
            }

            combination.add(arr[i]);
            helper(ans, combination, arr, target - arr[i], i + 1);
            combination.remove(combination.size() - 1);
        }
    }

}
