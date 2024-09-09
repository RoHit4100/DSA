package Strivers.SldingWindowAndTwoPointer.Hard;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentIntegers {
    // optimal solution
    public int subArraysWithKDistinct(int[] nums, int k) {
        int first = slidingWindow(nums, k);
        int second = slidingWindow(nums, k - 1);
        return first - second;
    }

    private int slidingWindow(int[] arr, int k){
        if(k <= 0){
            return 0;
        }
        // create the map which stores the freq
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;

        while(right < arr.length){
            // add the current item into the map, with its freq
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // check the size of the map, reduce if exceeds the k
            while(map.size() > k && left < right){
                // get the freq of left pointer
                int freq = map.get(arr[left]);
                freq--;
                // check if freq is 0 or not, if zero then remove that element from the map
                if(freq == 0){
                    map.remove(arr[left]);
                }else { // add that item into the map with updated freq
                    map.put(arr[left], freq);
                }

                // move the left pointer
                left++;
            }

            if(map.size() <= k){
                count += (right - left + 1);
            }
            right++;
        }

        return count;
    }
}
