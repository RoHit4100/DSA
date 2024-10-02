package ProblemOfTheDay.LeetCode;
import java.util.*;

public class RankOfNumberInArray {
    // this will be the brute force solution
    public int[] arrayRankTransform(int[] arr) {
        // Use a TreeMap to store unique values and their ranks
        Map<Integer, Integer> map = new TreeMap<>();

        // First, populate the map with the unique values
        for (int num : arr) {
            map.put(num, 0); // We only care about the value, not the index
        }

        // Assign ranks to the sorted values in the TreeMap
        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            entry.setValue(rank++);
        }

        // Now, build the result using the rank from the map
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]); // Get the rank for each original value
        }

        return ans;
    }
}
