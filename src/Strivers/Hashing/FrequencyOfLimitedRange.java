package Strivers.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfLimitedRange {
    public static void frequencyCount(int[] arr, int n, int p) {
        // brute force solution using hashMap
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.fill(arr, 0);
        // now replace the values of array
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            int num = entry.getKey();
            if(num > n){
                continue;
            }
            int correct = num - 1;
            arr[correct] = entry.getValue();
        }
    }
}
