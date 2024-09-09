package Strivers.SldingWindowAndTwoPointer.Medium;
import java.util.*;
public class NumberOfSubstringsWithAll3Character {
    public int numberOfSubstringsBetter(String s) {
        int[] tracker = new int[3];
        Arrays.fill(tracker, -1);
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            // update the last seen index
            char ch = s.charAt(i);
            tracker[ch - 'a'] = i;
            // now check if 3 of them are assigned or not
            if(tracker[0] != -1 && tracker[1] != -1 && tracker[2] != -1){ // this condition means that I have found 3 elements
                int c = 1 + Math.min(tracker[0], Math.min(tracker[1], tracker[2])); // min will be found this way,
                count += c;
            }
        }
        return count;
    }


    public int numberOfSubstrings(String s) {
        // brute solution will be generating all the substring and find the count of those substrings
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            // create hash array of 3, for each iteration
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                set.add(s.charAt(j));
                if(set.size() == 3){
                    count++;
                }
            }
        }
        return count;
    }


    public int numberOfSubstringsBetterThanBrute(String s) {
        // brute solution will be generating all the substring and find the count of those substrings
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            // create hash array of 3, for each iteration
            int[] hash = new int[3];
            for(int j = i; j < s.length(); j++){
                hash[s.charAt(j) - 'a'] = 1;
                if(hash[0] + hash[1] + hash[2] == 3){
                    count += s.length() - j;
                    break;
                }
            }
        }
        return count;
    }
}
