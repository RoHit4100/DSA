package Strivers.Graphs.Hard;

import java.util.*;

public class WordLadder1 {
    // using bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;

        // Insert all words in the wordList into a set for fast lookup
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();  // Number of elements at current level

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Convert to character array to try replacing each character
                for (int j = 0; j < current.length(); j++) {
                    char[] arr = current.toCharArray();

                    // Replace each character with 'a' to 'z'
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                        String newWord = new String(arr);

                        // If the newWord equals endWord, return the level + 1
                        if (endWord.equals(newWord)) return level + 1;

                        // If the newWord is in the set, add it to the queue and remove it from the set
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            level++;  // Increment level after processing all words at the current level
        }
        return 0;  // If endWord is not reached, return 0
    }
}
