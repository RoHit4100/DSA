package Strivers.BitManipulation.Hard;

import java.util.HashMap;
import java.util.Map;

public class SingleNum3 {
    // this will be the brute force solution
    public int[] singleNumber(int[] nums) {
        // brute force approach will be using hashMap
        Map<Integer, Integer> map = new HashMap<>();

        // now add all the values into the hashMap with their frequency
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // now find the numbers which has frequency as 1
        int[] ans = new int[2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                ans[index] = entry.getKey();
                index++;
            }
            if(index == 2){
                break;
            }
        }
        return ans;
    }


    // this is the most optimal solution
    public int[] singleNumberOptimal(int[] nums) {
        // First find the xor of nums, which will give the xor of the two unique elements
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        /*
           Calculation:

            xor = 12 (binary: 1100)
            -xor = -12 (binary: 0100 in 2's complement form)
            rightMost = 12 & (-12) = 4 (binary: 0100)
            The rightmost set bit is 4 (binary: 0100), which corresponds to the third bit from the right.
         */
        // Find the rightmost set bit (which differentiates the two unique numbers)
        int rightMost = xor & (-xor);

        // Initialize two buckets to 0
        int bucket1 = 0;
        int bucket2 = 0;

        // Traverse the array and separate numbers into two buckets
        for (int num : nums) {
            if ((num & rightMost) == 0) { // one of the unique element will be store in first bucket
                bucket1 ^= num;
            } else {
                bucket2 ^= num;
            }
        }

        return new int[]{bucket1, bucket2};
    }
}
