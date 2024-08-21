package Strivers.Arrays;
import java.util.*;
public class MergeIntervals {
    public int[][] merge(int[][] arr) {
        int n = arr.length;

        // Sort the given intervals by their starting points
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        // Use a list to store the merged intervals temporarily
        List<int[]> mergedList = new ArrayList<>();

        // Initialize the start and end to the first interval
        int start = arr[0][0];
        int end = arr[0][1];

        for (int i = 1; i < n; i++) { // Iterate through intervals
            if (arr[i][0] <= end) {
                // Overlapping intervals, update the end if necessary
                end = Math.max(end, arr[i][1]);
            } else {
                // Non-overlapping interval, add the previous interval and reset start and end
                mergedList.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        // Add the last interval
        mergedList.add(new int[]{start, end});

        // Convert the list of intervals to a 2D array
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
