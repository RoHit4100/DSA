package Strivers.Strings;

import java.util.HashMap;
import java.util.Map;

public class MaxFreqOfWordInArray {
    public String mostFrequentWord(String[] arr, int n) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        Map<String, Integer> firstOccurrenceMap = new HashMap<>();

        String result = "";
        int maxFrequency = 0;

        for (int i = 0; i < n; i++) {
            String word = arr[i];
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);

            // Store the first occurrence of the word
            if (!firstOccurrenceMap.containsKey(word)) {
                firstOccurrenceMap.put(word, i);
            }

            // Check if we need to update the result
            int currentFrequency = frequencyMap.get(word);
            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                result = word;
            } else if (currentFrequency == maxFrequency) {
                // In case of tie in frequency, we choose the word with the latest first occurrence
                if (firstOccurrenceMap.get(word) > firstOccurrenceMap.get(result)) {
                    result = word;
                }
            }
        }

        return result;
    }
}
