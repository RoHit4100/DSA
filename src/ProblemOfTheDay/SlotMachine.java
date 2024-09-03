package ProblemOfTheDay;
import java.util.*;
public class SlotMachine {
    public static int calculatePoints(String original, String guess) {
        int perfectHits = 0;
        Set<Character> originalSet = new HashSet<>();
        Set<Character> guessSet = new HashSet<>();

        // Step 1: Calculate perfect hits and prepare sets for pseudo hits
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == guess.charAt(i)) {
                perfectHits += 2;
            } else {
                originalSet.add(original.charAt(i));
                guessSet.add(guess.charAt(i));
            }
        }

        // Step 2: Calculate pseudo hits
        originalSet.retainAll(guessSet);
        int pseudoHits = originalSet.size();

        // Total points = Perfect hits + Pseudo hits
        return perfectHits + pseudoHits;
    }
}
