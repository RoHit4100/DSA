package Strivers.GreedyAlgorithms.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {
    class Job {
        // Attributes of a Job: id, profit, and deadline
        int id, profit, deadline;

        // Constructor to initialize a job
        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    int[] JobScheduling(Job[] arr, int n) {
        // Sort jobs in descending order of profit using a comparator
        Comparator<Job> comp = new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.profit > o2.profit) {
                    return -1; // Return -1 if o1's profit is greater (for descending order)
                } else if (o1.profit < o2.profit) {
                    return 1;  // Return 1 if o2's profit is greater
                } else {
                    return 0;  // Return 0 if profits are equal
                }
            }
        };

        // Sort the array of jobs using the above comparator
        Arrays.sort(arr, comp);

        // Find the maximum deadline to determine the number of days available
        int maxDays = 0;
        for (Job job : arr) {
            maxDays = Math.max(job.deadline, maxDays);
        }

        // Array to track which day is occupied by which job (initialize all days as -1 meaning free)
        int[] days = new int[maxDays + 1];
        Arrays.fill(days, -1); // Mark all days as free initially

        int count = 0;      // To count the number of jobs scheduled
        int maxProfit = 0;   // To keep track of the total profit

        // Iterate through each job and try to schedule it
        for (Job job : arr) {
            // Find the latest available slot on or before the job's deadline
            int i = job.deadline;
            while (i > 0) {
                // If a free slot is found schedule the job
                if(days[i] != -1){
                    days[i] = job.id; // Assign the job ID to that day
                    maxProfit += job.profit; // Add the profit from this job
                    count++; // Increment the count of scheduled jobs
                    break; // again repeat for others jobs
                }
                i--;  // Move backwards to find a free day
            }
        }

        // Return the total number of jobs scheduled and the maximum profit achieved
        return new int[]{count, maxProfit};
    }
}
