package Strivers.Recursion.Questions.Hard;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>  ans = new ArrayList<>();  // create answer list to return
        helper(ans, new ArrayList<>(), 0, 1, k, n); // call helper function.
        return ans;
    }


    private void helper(List<List<Integer>> ans, List<Integer> combination, int sum, int num, int size, int n){
        if(combination.size() == size){ // check if the size exceeds the given length
            if(sum == n){ // if yes, then check the sum that we have got till that point is equal to what we asked for
                ans.add(new ArrayList<>(combination)); // and that combination into the answer
            }
            return; // return in both of the case
        }


        for(int i = num; i < 10; i++){ // we will check every number once, till 9
            if(sum + i > n){ // check if adding current number into the sum, will give the valid sum or not
                break; // if not then just break out of that loop, as next number will also exceed the threshold
            }

            combination.add(i); // add valid number into the combination
            sum += i; // add the number with sum variable
            helper(ans, combination, sum, i + 1, size, n); // call recursively for next numbers
            sum -= i; // after coming out the recursion, remove the recently added element from the sum
            combination.remove(combination.size() - 1); // remove the last added number
        }
    }
}
