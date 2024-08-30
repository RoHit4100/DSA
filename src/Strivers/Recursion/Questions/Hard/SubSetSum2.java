package Strivers.Recursion.Questions.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum2 {
    public List<List<Integer>> subsetsWithDup1(int[] arr) {
        Arrays.sort(arr); // sort the array

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        // call the function
        helper(ans, subset, arr, 0);
        return ans;
    }


    private void helper(List<List<Integer>> ans, List<Integer> subset, int[] arr, int index){
        // add the current subset into the ans
        ans.add(new ArrayList(subset));

        for(int i = index; i < arr.length; i++){
            // check if current element is similar to previous element, if similar then don't pick this element
            // check for this except for the first index
            if(i > index && arr[i] == arr[i - 1]){
                continue;
            }

            // if we are at this line means we have got the unique element or first index element, then just pick this element
            // and add it into subset
            subset.add(arr[i]);
            //call function
            helper(ans, subset, arr, i + 1);
            // remove last added element
            subset.remove(subset.size() - 1);
        }
    }


    // kunal's solution using iterative approach
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);

        // create a list to store all the lists
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>()); // initially it will be an empty list
        int start = 0;
        int end = 0;

        // traverse for each element
        for(int i = 0; i < arr.length; i++){
            // if similar elements then start adding from the last list of the previous iteration
            if(i > 0 && arr[i] == arr[i - 1]){
                start = end + 1; // next location from last end, in this case we will add elements from the last's next location of the outer
            }else {
                start = 0; // if not duplicate then add the current number from first list
            }
            end = outer.size() - 1; // store the last end location of the outer
            int n = outer.size(); // the total subsets depends on the size of the outer
            for(int j = start; j < n; j++){
                // create new Array list same as jth index
                List<Integer> list = new ArrayList<>(outer.get(j)); // get same list as jth location
                list.add(arr[i]); // add current element into that list
                outer.add(list); // add the current list into the outer
            }
        }
        return outer;
    }
}
