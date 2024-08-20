package ProblemOfTheDay;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {3, -3, 1, 1, 1};
        System.out.println(returnCount(arr, 3));
    }

    static int returnCount(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; // this will ensure the count of total subarrays
        int preSum = 0;
        map.put(0, 1); // this will make sure when a sub array is encounter with exact value of k, the count will be 1

        for(int i = 0; i < arr.length; i++){
            preSum += arr[i]; // this line will add the current value with the pre sum

            int require = preSum - k; // e.g. 6 - 6 = 0, in this case we have to increase the count, as sub array exists
            count += map.getOrDefault(require, 0);

            // now just insert the current pre sum and the count for that respective presum
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
