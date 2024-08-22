package Strivers.ArraysQuestions;
import java.util.*;
public class XOROfSubArrayWithValueK {
    public static int subArraysWithSumK(int []arr, int b) {
        // Write your code here
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Initial case for the empty prefix
        map.put(0, 1);

        for (int num : arr) {
            // Calculate current prefix XOR
            xor ^= num;

            // Find if there exists a prefix with XOR that when XORed with the current xor gives b
            int requiredXOR = xor ^ b;

            // If the required XOR exists in the map, add its frequency to count
            count += map.getOrDefault(requiredXOR, 0);

            // Store the current prefix XOR in the map
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }




    // leetcode
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXor = new int[n];
        int[] result = new int[queries.length];

        // Step 1: Build the prefixXor array
        prefixXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }

        // Step 2: Answer each query using the prefixXor array
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                result[i] = prefixXor[right];
            } else {
                result[i] = prefixXor[right] ^ prefixXor[left - 1];
            }
        }

        return result;
    }


}
