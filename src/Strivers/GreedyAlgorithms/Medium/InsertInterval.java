package Strivers.GreedyAlgorithms.Medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){ // edge case when there are no intervals
            return new int[][] {newInterval};
        }

        List<int[]> result = new ArrayList<>(); // create list of result, to store the ans

        // first find the first half, which is not overlapping
        int i = 0; // initial index
        int n = intervals.length; // length of the intervals
        while(i < n && intervals[i][1] < newInterval[0]){ // run this loop till intervals end is smaller than the start of the new Interval
            result.add(intervals[i]); // add all the non overlapping intervals into the result
            i++; // increment the index
        }

        // now we have found the overlapping part, now merge the all overlapping intervals
        while(i < n && intervals[i][0] <= newInterval[1]){ // run this loop till start of the overlapping interval is smaller than the end of the new Interval
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]); // take the min of the start
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]); // take the max of the end
            i++; // increment the index
        }

        // now we have found the created one merged interval from overlapping intervals, add that into our ans
        result.add(newInterval);

        // add the rest of the intervals into ans
        while(i < n){
            result.add(intervals[i]); // add the rest of the intervals into result
            i++;
        }

        return result.toArray(new int[result.size()][]); // convert the result list into 2d array with the help of toArray method
    }
}
