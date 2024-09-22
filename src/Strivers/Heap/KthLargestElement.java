package Strivers.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // we can solve this question using priority queue
        // first insert every item into priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num: nums){
            maxHeap.offer(num);
        }

        // now pop the k-1 items from heap
        for(int i = 1; i < k; i++){
            maxHeap.poll();
        }

        return maxHeap.poll();
    }
}
