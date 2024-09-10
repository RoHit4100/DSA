package Strivers.GreedyAlgorithms.Medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PageFaultsInLRU {
    static int pageFaults(int n, int capacity, int[] pages){
        if (capacity == 0) return n;  // If capacity is 0, every page reference results in a fault

        Set<Integer> set = new HashSet<>(); // Set to store the current pages in memory (cache)
        Deque<Integer> deque = new LinkedList<>(); // Deque to maintain the order for LRU

        int pageFaults = 0; // Counter for page faults

        for (int page : pages) {
            // Case when the page is not in cache (page fault)
            if (!set.contains(page)) {
                pageFaults++;  // Increment page fault

                // If the cache is full, remove the least recently used page
                if (deque.size() == capacity) {
                    int lru = deque.removeFirst(); // Remove LRU page from the front
                    set.remove(lru);               // Remove the page from the set as well
                }

                // Add the new page to cache (deque and set)
                deque.addLast(page);
                set.add(page);
            } else {
                // If the page is already in cache (no page fault), update the order
                deque.remove(page); // Remove the page from its current position
                deque.addLast(page); // Move the page to the back (most recently used)
            }
        }

        return pageFaults;
    }
}
