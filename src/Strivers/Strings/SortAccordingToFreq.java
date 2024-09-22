package Strivers.Strings;
import java.util.*;
public class SortAccordingToFreq {
    public String frequencySort(String s) {
        // Step 1: Count the frequency of each character in the string
        Map<Character, Integer> map = new HashMap<>();

        // Iterate over the string, updating the frequency count for each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Use a max heap (priority queue) to store entries in descending order of frequency
        // Comparator: Sort based on the frequency (b.getValue() - a.getValue()).
        // This ensures that the priority queue behaves like a max heap, with the most frequent
        // element having the highest priority (at the front of the queue).
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() // Comparator: max heap by frequency
        );

        // Add all the entries from the map to the max heap
        maxHeap.addAll(map.entrySet());

        // Step 3: Build the result string by polling the max heap
        StringBuilder ans = new StringBuilder();

        // Extract characters from the heap one by one based on their frequency
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll(); // Get the entry with max frequency
            char ch = entry.getKey(); // The character
            int freq = entry.getValue(); // Its frequency

            // Append the character 'freq' number of times to the result string
            while (freq > 0) {
                ans.append(ch);
                freq--;
            }
        }

        // Return the final sorted string based on character frequencies
        return ans.toString();
    }

}
