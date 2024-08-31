package Strivers.Recursion.Questions.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> combination = new ArrayList<>();
        boolean[] tracker = new boolean[n + 1];
        helper(ans, combination, tracker, n, k, 1);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> combination, boolean[] tracker, int n, int size, int start){
        if(combination.size() == size){
            // add answer and return
            ans.add(new ArrayList<>(combination));
            return;
        }


        // traverse from 1 to n
        for(int i = start; i <= n; i++){
            if(!tracker[i]){
                // take it
                combination.add(i);
                helper(ans, combination, tracker, n, size, i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }

    // optimized solution without using tracker
    public List<List<Integer>> combineOptimized(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> combination = new ArrayList<>();
        helper(ans, combination, n, k, 1);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> combination, int n, int size, int start){
        if(combination.size() == size){
            // add answer and return
            ans.add(new ArrayList<>(combination));
            return;
        }


        // traverse from 1 to n
        for(int i = start; i <= n; i++){
            combination.add(i);
            helper(ans, combination, n, size, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
