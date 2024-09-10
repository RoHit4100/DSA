package Strivers.GreedyAlgorithms.Medium;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        // same numerical as N-Meetings in a room
        // first sort the intervals based on the ending of the interval
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // sort in ascending order based on ending of the interval

        // now traverse through intervals and calculate the non overlapping intervals
        int result = 0; // this will count the overlapping intervals
        int prevEnd = intervals[0][1]; // remember the prev end of the interval
        for(int i = 1; i < intervals.length; i++){
            if(prevEnd > intervals[i][0]){ // check if prev end is greater than the start of the interval
                result++; // if yes, then that means this interval is overlapping
            }else{
                prevEnd = intervals[i][1]; // if not overlapping then update the prev end
            }
        }
        // return the number of overlapping intervals
        return result;
    }
}
