package Strivers.Hashing;
import java.util.*;
public class HighestAndLowestFreq {
    public static int[] getFrequencies(int[] v) {
        // HashMap to store the frequency of each element.
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Fill the frequency map.
        for (int num : v) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Initialize variables for highest and lowest frequency elements.
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;
        int maxElement = Integer.MAX_VALUE;
        int minElement = Integer.MAX_VALUE;

        // Iterate through the frequency map to find the highest and lowest frequency elements.
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();

            // Check for the element with the highest frequency.
            if (frequency > maxFreq || (frequency == maxFreq && element < maxElement)) {
                maxFreq = frequency;
                maxElement = element;
            }

            // Check for the element with the lowest frequency.
            if (frequency < minFreq || (frequency == minFreq && element < minElement)) {
                minFreq = frequency;
                minElement = element;
            }
        }

        // Return the result as an array [highest frequency element, lowest frequency element].
        return new int[]{maxElement, minElement};
    }
}
