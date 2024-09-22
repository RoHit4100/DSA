package Strivers.Strings;
import java.util.*;
public class Anagram {
    // optimal solution
    public boolean isAnagramOptimal(String s, String t) {
        // optimal approach will be sorting the arrays and checking for not matching characters
        if(s.length() != t.length()) return false;

        char[] first = s.toCharArray(); // convert the first string into array
        char[] second = t.toCharArray(); // convert the second string into array

        Arrays.sort(first); // sort the first string
        Arrays.sort(second); // sort the second string

        for(int i = 0; i < s.length(); i++){ // no go through the strings, and check for the violation
            if(first[i] != second[i]) return false;
        }
        // if violation is not found the return true
        return true;
    }


    // brute force solution
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // now go through second string
        for(char ch: t.toCharArray()){
            // now check if this character exists in the map or not, if not then return false
            if(!map.containsKey(ch)) return false;
            else{
                // get the freq
                int freq = map.get(ch);
                // reduce the freq
                freq--;
                // if freq is 0 then remove that character from the map
                if(freq == 0){
                    map.remove(ch);
                }else{
                    // update the freq, and insert again
                    map.put(ch, freq);
                }
            }
        }

        return map.isEmpty();
    }
}
