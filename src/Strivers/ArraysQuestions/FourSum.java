package Strivers.ArraysQuestions;

import java.util.*;

public class FourSum {

    // optimal approach which includes not using hashSet instead we'll just sort the array and perform operations on that
    static List<List<Integer>> fourSumOptimal(int[] nums, int target){
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        List<List<Integer>> ans = fourSumBF(arr, 8);
        for(List<Integer> list: ans){
            System.out.println(list);
        }

        List<List<Integer>> ans1 = fourSumBetter(arr, 8);
        for(List<Integer> list: ans1){
            System.out.println(list);
        }
    }

    // better approach will use the hashing and finding the required element into the hash
    static List<List<Integer>> fourSumBetter(int[] arr, int target){
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        // in this solution we will not use the last loop, instead we will search the required element into the hash set
        for(int i = 0; i < n; i++){
            HashSet<Integer> map = new HashSet<>();
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    int required = target - (arr[i] + arr[j] + arr[k]);
                    if(map.contains(required)){
                        // add the elements into the list
                        List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k], required);
                        Collections.sort(list);

                        set.add(list);
                    }

                    map.add(arr[k]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    // brute force approach
    static List<List<Integer>> fourSumBF(int[] arr, int target){
        int n = arr.length;
        // we will follow the same approach as the threeSum
        // run for loops each index will be next of previous
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    for(int l = k + 1; l < n; l++){
                        long sum = arr[i] + arr[j] + arr[k] + arr[l];
                        if(sum == target){
                            // add the elements into the list
                            List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(list);

                            set.add(list);
                        }
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
