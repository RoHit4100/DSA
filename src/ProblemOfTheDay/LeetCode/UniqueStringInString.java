package ProblemOfTheDay.LeetCode;

import java.util.*;

public class UniqueStringInString {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Step 1: Create a map to store word counts
        Map<String, Integer> map = new HashMap<>();

        // Step 2: Split both sentences into words by concatenating them and splitting by spaces
        String[] words = (s1 + " " + s2).split(" ");

        // Step 3: Loop through each word in the array 'words'
        for (String str : words) {
            // For each word, update its count in the map.
            // If the word is not in the map, add it with a count of 1.
            // If it already exists, increment its count by 1.
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // Step 4: Create a list to store the result (words that appear exactly once)
        List<String> result = new ArrayList<>();

        // Step 5: Iterate through the map to find words that appear exactly once
        for (String key : map.keySet()) {
            // Add words that have a count of 1 to the result list
            if (map.get(key) == 1) {
                result.add(key);
            }
        }

        // Step 6: Convert the list of uncommon words to a String array and return it
        return result.toArray(new String[0]);
    }
}
