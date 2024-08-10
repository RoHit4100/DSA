package Kunal.Hash.Questions;
import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to a HashSet for O(1) contains() and remove() operations
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Initialize a queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int length = 1; // Start with length 1 for the beginWord

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Iterate over each character in the current word
                for (int j = 0; j < current.length(); j++) {
                    char[] charArray = current.toCharArray();

                    // Try changing each letter to all possible letters from 'a' to 'z'
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArray[j] = ch;
                        String newWord = new String(charArray);

                        // Check if we have reached the endWord
                        if (newWord.equals(endWord)) {
                            return length + 1;
                        }

                        // If the newWord is in the wordSet, add it to the queue and remove it from the set
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }

            // Increment the length after finishing the current level of BFS
            length++;
        }

        // If no transformation sequence found, return 0
        return 0;
    }
}
