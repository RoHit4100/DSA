package Strivers.ArraysQuestions;
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



    // coding ninja
    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length; // size of the array
        //sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // if the current interval does not
            // lie in the last interval:
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            // if the current interval
            // lies in the last interval:
            else {
                ans.get(ans.size() - 1).set(1,
                        Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;
    }
}
