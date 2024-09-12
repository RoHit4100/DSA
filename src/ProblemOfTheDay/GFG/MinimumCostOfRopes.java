package ProblemOfTheDay.GFG;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public long minCost(long[] arr) {
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        // first insert all the values into the heap
        for (long cost : arr) {
            minheap.add(cost);
        }

        long sum = 0;
        // Now, get the two smallest elements from the minheap and sum them up
        while (minheap.size() > 1) {
            long min = minheap.poll();
            long secondMin = minheap.poll();
            long currentSum = min + secondMin;
            sum += currentSum;
            minheap.offer(currentSum);
        }
        return sum;
    }
}
