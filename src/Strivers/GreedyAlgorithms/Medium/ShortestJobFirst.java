package Strivers.GreedyAlgorithms.Medium;

import java.util.Arrays;

public class ShortestJobFirst {

    static int solve(int[] bt) {
        // code here
        int waitingTime = 0; // to calculate the waiting time
        int prev = 0; // it will store the last waiting time
        Arrays.sort(bt); // first sort the burst time array

        for(int i = 0; i < bt.length - 1; i++){ // go till second last element
            prev += bt[i]; // get the prev
            waitingTime += prev; // add the prev into waiting time
        }

        return waitingTime / bt.length; // return the average waiting time
    }
}
