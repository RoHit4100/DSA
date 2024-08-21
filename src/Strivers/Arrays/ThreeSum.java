package Strivers.Arrays;

import java.util.*;

public class ThreeSum {
    // optimal approach
    static List<List<Integer>> threeSumOptimal(int[] arr) {
        // Sort the array
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Skip duplicate elements
            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            // Two-pointer approach
            int j = i + 1; // Pointer starting from the element after i
            int k = arr.length - 1; // Pointer starting from the last element

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0) {
                    j++; // Increase sum by moving the left pointer right
                } else if (sum > 0) {
                    k--; // Decrease sum by moving the right pointer left
                } else {
                    // Found a triplet that sums to 0
                    List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(list);

                    j++;
                    k--;

                    // Skip duplicate elements for j and k
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }


    // better solution will be using the hashset
    static  List<List<Integer>> threeSumBetter(int[] arr){
        // first create the hashset
        Set<List<Integer>> set = new HashSet<>();
        // now create another set for values
        HashSet<Integer> map = new HashSet<>();

        // now traverse from the array
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int require = -(arr[i] + arr[j]);
                if(map.contains(require)){
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(require);
                    Collections.sort(list);
                    set.add(list);
                }
                map.add(arr[j]);
            }
            map.clear();
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {-1, 0,1,2,-1,-4};
        List<List<Integer>> ans = threeSumBF(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }

        System.out.println("better approach");
        List<List<Integer>> ans1 = threeSumBetter(arr);
        for(List<Integer> list: ans1){
            System.out.println(list);
        }
    }

    // in this question we have to find the triplets which gives the sum == 0;
    // brute force approach

    static List<List<Integer>> threeSumBF(int[] arr){
        // here we will run 3 loops for 3 different element with the O(n3) complexity
        Set<List<Integer>> set = new HashSet<>();
        // for each iteration we will create a list
        for(int i = 0; i < arr.length; i++){ // this loop will for first element

            for(int j = i + 1; j < arr.length; j++){ // this loop will be for second element
                for(int k = j + 1; k < arr.length; k++){ // this loop will run for 3rd element
                    long sum = arr[i] + arr[j] + arr[k];
                    if(sum == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);

                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
