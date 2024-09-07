package Strivers.SldingWindowAndTwoPointer.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    // this will be the brute force solution, which includes generating all the substrings and finding the length of the max substring
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
                set.add(s.charAt(j));
            }
        }

        return maxLength;
    }


    // this will be the optimal solution
    public int lengthOfLongestSubstringOptimal(String s) {
        // better approach will be using sliding window with two pointers, and Map
        Map<Character, Integer> map = new HashMap<>(); // get the map, to store the index and character present at that index
        int maxLength = 0; // this will store the maxLength
        int left = 0, right = 0; // initialize the window pointers
        while(right < s.length()){ // now run till right goes out off bound
            if(map.containsKey(s.charAt(right))){ // check if map contains the current character or not
                int index = map.get(s.charAt(right)); // get the index of that character
                if(index >= left){ // check the index in the window or not, if not then don't do anything
                    left = index + 1; // if character is repeating and present in the current subset, then go next to the repeating index
                }
            }

            // now calculate the index
            int length = right - left + 1;
            maxLength = Math.max(length, maxLength); // set the max
            map.put(s.charAt(right), right); // insert the current character and its index in the map
            right++; // move right by one
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
