package Strivers.ArraysQuestions;
import java.util.*;
public class CountOfSubArrayWithSumK {
    public int subArraySum(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1); // We initialize the map with (0, 1) because a sum of 0 is the base case,
        // which allows counting subarrays starting from index 0 that directly sum to k.
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // get the target value from the map
            int targetVal = sum - k;
            // check if that value exist into the map or not
            if (freqMap.containsKey(targetVal)) {
                // get the frequency present at that targetValue, which will be the sum
                count += freqMap.get(targetVal);
            }

            // now update the map, by increasing the existing value of that key
            freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
