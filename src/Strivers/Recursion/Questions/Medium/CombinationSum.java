package Strivers.Recursion.Questions.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        generate(ans, combination, candidates, 0, target);
        return ans;
    }

    private void generate(List<List<Integer>> ans, List<Integer> combination, int[] candidates, int index, int target){
        if(target == 0 || index >= candidates.length){
            // check if target is 0 or not
            if(target == 0) {
                // add the current valid combination into the ans
                ans.add(new ArrayList<>(combination));
            }
            return;
        }

        // first check if by subtracting the current index element with target, target remains greater than 0
        if(target - candidates[index] >= 0){
            // add the current item into the combination
            combination.add(candidates[index]);
            generate(ans, combination, candidates, index, target - candidates[index]); // call the same with function with same index
            combination.remove(candidates[index]); // remove the added element
        }

        generate(ans, combination, candidates, index + 1, target);
    }
}
