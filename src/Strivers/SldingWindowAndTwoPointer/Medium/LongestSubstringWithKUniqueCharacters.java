package Strivers.SldingWindowAndTwoPointer.Medium;
import java.util.*;
public class LongestSubstringWithKUniqueCharacters {
    // this will be the most optimal solution
    public int longestSubst(String s, int k) {
        // code here
        // optimal solution using sliding window
        int left = 0, right = 0;
        int maxLength = -1;
        Map<Character, Integer> map = new HashMap<>(); // this map will store the character and its freq

        while(right < s.length()){
            // add the current item and its freq into the map
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            // now check if the size of the map is greater than k or not
            if(map.size() > k){
                // get the freq of left item
                char ch = s.charAt(left);
                int f = map.get(ch);

                // reduce the freq by 1
                f--;
                // check if freq is 0 or not
                if(f == 0){
                    // remove that element from the map
                    map.remove(ch);
                }else{
                    map.put(ch, f); // if freq is not zero then update the freq
                }
                left++; // increment the left pointer
            }

            if(map.size() == k){
                maxLength = Math.max(maxLength, right - left + 1); // get the length
            }
            right++; // move the right pointer at every iteration
        }

        return maxLength;
    }
    public int longestKSubStr(String s, int k) {
        // code here
        // brute force solution will be generating all the substring with set size
        int maxLength = -1;
        for(int i = 0; i < s.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                set.add(s.charAt(j));
                if(set.size() > k){
                    break;
                }
                if(set.size() == k){
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
}
