package ProblemOfTheDay.LeetCode;
import java.util.*;
public class PermutationsInString {
    // this will be the optimal solution
    public boolean checkInclusionOptimal(String s1, String s2) {
        // using arrays
        if(s2.length() < s1.length()) return false;

        if(s2.contains(s1)) return true;

        int[] first = new int[26];
        int[] second = new int[26];

        // first add all the frequencies of the s1 in first
        for(char ch: s1.toCharArray()){
            first[ch - 'a']++;
        }

        // now use the sliding window algorithm and maintain the s1.length() window size
        int window = s1.length() - 1;
        for(int i = 0; i < s2.length(); i++){
            second[s2.charAt(i) - 'a']++;

            // check if i >= window size or not
            if(i >= window){
                // in this case check if both of the arrays has the same frequencies of the same values or not
                if(match(first, second)) return true;
                // if not then reduce the window size


                int removeIndex = i - window;
                second[s2.charAt(removeIndex) - 'a']--;
            }
        }
        return false;
    }

    private boolean match(int[] first, int[] second){
        // now check in both the arrays, that every index has the same values, if not then return false;
        for(int i = 0; i < first.length; i++){
            if(first[i] != second[i]) return false;
        }

        return true;
    }

    // this will be the better solution
    public boolean checkInclusionBetter(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // Frequency map for s1
        Map<Character, Integer> s1Map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        // Sliding window
        Map<Character, Integer> s2Map = new HashMap<>();
        int left = 0, right = 0;

        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            // Add the current character to the window
            s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);
            right++;

            // If the window size is larger than s1, remove the leftmost character
            if (right - left > s1.length()) {
                char leftChar = s2.charAt(left);
                if (s2Map.get(leftChar) == 1) {
                    s2Map.remove(leftChar); // Remove character if its count becomes 0
                } else {
                    s2Map.put(leftChar, s2Map.get(leftChar) - 1);
                }
                left++;
            }

            // Check if the frequency maps are equal
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }

        return false;
    }

    // this will be the brute force solution
    public boolean checkInclusion(String s1, String s2) {
        // brute force will be finding all the permutations and then checking if the permutations exists in the stirng or not
        List<String> permutations = new ArrayList<>();
        findPermutations(new StringBuilder(), s1, new boolean[s1.length()], permutations);

        // System.out.println(permutations);
        // now we have all the permutations, check if s2 contains any of the permutations or not
        for(String permutation: permutations){
            if(s2.contains(permutation)) return true;
        }
        return false;
    }

    private void findPermutations(StringBuilder p, String up, boolean[] tracker, List<String> list){
        if(p.length() == up.length()){
            list.add(p.toString());
            return;
        }

        for(int i = 0; i < up.length(); i++){
            // first check if the current index is taken or not
            if(!tracker[i]){ // this means not taken
                p.append(up.charAt(i));
                tracker[i] = true;
                findPermutations(p, up, tracker, list);
                tracker[i] = false;
                p.deleteCharAt(p.length() - 1);
            }
        }
    }

    // this will save some space complexity
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if(s2.contains(s1)) return true;
            return findPermutations(new StringBuilder(), s1, new boolean[s1.length()], s2);
        }

        private boolean findPermutations(StringBuilder p, String up, boolean[] tracker, String s2){
            if(p.length() == up.length()){
                if(s2.contains(p.toString())){
                    return true;
                }
                return false;
            }

            for(int i = 0; i < up.length(); i++){
                // first check if the current index is taken or not
                if(!tracker[i]){ // this means not taken
                    p.append(up.charAt(i));
                    tracker[i] = true;
                    boolean check = findPermutations(p, up, tracker, s2);
                    if(check) return true;
                    tracker[i] = false;
                    p.deleteCharAt(p.length() - 1);
                }
            }

            return false;
        }
    }
}
