package Strivers.SldingWindowAndTwoPointer.Hard;

public class MinimumWindowSubstring {
    // optimal solution
    class Solution {
        public String minWindow(String s, String t) {
            if(t.equals(s)){
                return s; // return if both of the strings are equal
            }
            if (t.length() > s.length()) {
                return ""; // return empty string if length of t is greater than s
            }

            // create hash Map
            int[] hash = new int[256]; // used to store the hash
            int start = -1;
            int minLength = Integer.MAX_VALUE; // this will be the min length of the ans string
            int count = 0; // to keep track of characters in s, which are present in the t

            // now first insert all the elements present in t into the hash
            for(int i = 0; i < t.length(); i++){
                hash[t.charAt(i)]++; // pre insert the hash of elements of t
            }

            // now we have hash ready
            // lets begin the sliding window algo
            int left = 0, right = 0;
            while(right < s.length()){
                // check if the current characters hash is positive or not
                if(hash[s.charAt(right)] > 0){ // this means this is character is present in t
                    count++; // increase the counter, counter will denote that we have found the requie number of characters
                }
                // now reduce the freq, negative freq means that, the character is not present in t
                hash[s.charAt(right)]--;

                // now check if the current count is equal to t length or not
                while(count == t.length()){ // this condition means that we have found the all the characters of t, in s
                    // first check if the current length is min or not, if min then assign the start and length
                    if(minLength > (right - left + 1)){
                        minLength = right - left + 1; // assign the min Length
                        start = left; // update the start
                    }
                    // now increase the freq or left character, increasing means removing
                    hash[s.charAt(left)]++;
                    if(hash[s.charAt(left)] > 0){ // check if hash is positive or not
                        count--;
                    }
                    left++;
                }
                right++;
            }

            if(start == -1){
                return "";
            }
            return s.substring(start, start + minLength);
        }
    }

    // this is the brute force solution
    public String minWindow(String s, String t) {
        if(t.equals(s)){
            return s;
        }
        if (t.length() > s.length()) {
            return "";
        }

        int start = -1;
        int minLength = Integer.MAX_VALUE; // Changed from s.length() - 1 to s.length()

        for (int i = 0; i < s.length(); i++) {
            // Insert the t elements into the map
            int[] hash = new int[256];
            int count = 0;
            for (int j = 0; j < t.length(); j++) {
                hash[t.charAt(j)]++;
            }
            // Traverse the string s from index i
            for (int j = i; j < s.length(); j++) {
                // Check if the hash of the current character is greater than zero
                if (hash[s.charAt(j)] > 0) {
                    count++;
                }
                hash[s.charAt(j)]--;

                // If we have found a valid window
                if (count == t.length()) {
                    if (j - i + 1 < minLength) {
                        start = i;
                        minLength = j - i + 1;
                    }
                    break; // No need to keep going after finding a valid window
                }
            }
        }
        // Return result
        if (start == -1) {
            return ""; // If no valid window was found
        }
        return s.substring(start, start + minLength); // Corrected substring method
    }
}
