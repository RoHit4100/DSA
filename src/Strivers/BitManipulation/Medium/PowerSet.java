package Strivers.BitManipulation.Medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] arr) {
        // Calculate the total number of subsets, which is 2^n
        int totalSubset = 1 << arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate over each possible subset
        for(int num = 0; num < totalSubset; num++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < arr.length; j++){
                // Check if the j-th bit in num is set
                if((num & (1 << j)) != 0){
                    list.add(arr[j]);
                }
            }
            ans.add(list);
        }

        return ans;
    }
}
