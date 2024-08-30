package Strivers.Recursion.Questions.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class SubSetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        // we will use the method of p and up, or take it or not take it
        ArrayList<Integer> ans = new ArrayList<>();
        helper(arr, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }

    private void helper(ArrayList<Integer> arr, ArrayList<Integer> ans, int index, int sum){
        if(index >= arr.size()){
            ans.add(sum);
            return;
        }

        // take it
        sum += arr.get(index);
        helper(arr, ans, index + 1, sum);

        // not take it
        sum -= arr.get(index);
        helper(arr, ans, index + 1, sum);
    }
}
