package Strivers.GreedyAlgorithms.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NMeetingsInRoom {
    // Define the Meeting class to store start time, end time, and position of each meeting.
    private class Meeting {
        int start; // starting time of the meeting
        int end; // ending time of the meeting
        int pos; // this helps to store the original position of the meeting

        // Constructor to initialize a meeting with start, end, and position.
        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public int maxMeetings(int n, int[] start, int[] end) {
        // This ArrayList will store all the meetings.
        ArrayList<Meeting> meetings = new ArrayList<>();

        // Add each meeting with its start time, end time, and position (1-based index).
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        // Create a comparator to sort the meetings by their end time.
        Comparator<Meeting> comp = new Comparator<Meeting>() {
            @Override
            public int compare(Meeting a, Meeting b) {
                // Sort primarily by end time in ascending order.
                if (a.end < b.end) {
                    return -1;
                } else if (a.end > b.end) {
                    return 1;
                } else {
                    // If the end times are the same, you can sort by position (optional).
                    return a.pos - b.pos;
                }
            }
        };

        // Sort the meetings based on their end time using the comparator.
        Collections.sort(meetings, comp);

        int totalMeetings = 0; // To track the total number of non-overlapping meetings.
        int endingTime = 0; // To store the end time of the last meeting that was added.

        // Loop through the sorted meetings.
        for (Meeting meeting : meetings) {
            // If this is the first meeting or its start time is after the previous meeting's end time.
            if (meeting.start > endingTime) {
                totalMeetings++; // Increment the meeting count.
                endingTime = meeting.end; // Update the end time to the current meeting's end.
            }
        }

        // Return the total number of non-overlapping meetings that can be held.
        return totalMeetings;
    }
}
