package Strivers.SldingWindowAndTwoPointer.Medium;

public class LongestRepeatingCharReplacement {
    // brute force solution
    public int characterReplacement(String s, int k) {
        // length - maxFreq, will be the formula to solve this question
        int maxLength = 0, maxFreq = 0; // this variables will keep track of maxLength and maxFreq
        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26]; // initialize new freq array for each iteration
            for(int j = i; j < s.length(); j++){ // substrings will start from i
                char ch = s.charAt(j); // get the character
                freq[ch - 'A']+=1; // increase the freq for that character
                maxFreq = Math.max(maxFreq, freq[ch - 'A']); // compare maxFreq for each iteration
                int length = j - i + 1; // get the length
                int changes = length - maxFreq; // calculate the changes needed to make, or replacements that need to be done
                if(changes <= k){ // check if the changes are smaller than k
                    maxLength = Math.max(maxLength, length); // update the maxLength
                }else{
                    break; // if changes exceeds the k break
                }
            }
        }
        // return maxLength
        return maxLength;
    }

    //better solution
    public int characterReplacementBetter(String s, int k) {
        // for better approach we will use the sliding window and two pointer technique

        int maxLength = 0, maxFreq = 0;
        int[] freq = new int[26];
        int right = 0, left = 0;
        while(right < s.length()){
            // first include the character into the map
            char ch = s.charAt(right);
            freq[ch - 'A']++; // update the frequency of the character
            // update the maxFreq
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // now check if the changes are less than we have allowed
            // now make the current window valid
            while((right - left + 1) - maxFreq > k && left < right){
                freq[s.charAt(left) - 'A']--;
                // now update the max Freq
                maxFreq = 0;
                for(int f: freq){
                    maxFreq = Math.max(f, maxFreq);
                }
                left++;
            }
            if((right - left + 1) - maxFreq  <= k){
                // update the maxLength
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }

        return maxLength;
    }

    // optimal solution
    public int characterReplacementOptimal(String s, int k) {
        // for better approach we will use the sliding window and two pointer technique

        int maxLength = 0, maxFreq = 0;
        int[] freq = new int[26];
        int right = 0, left = 0;
        while(right < s.length()){
            // first include the character into the map
            char ch = s.charAt(right);
            freq[ch - 'A']++; // update the frequency of the character
            // update the maxFreq
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // now check if the changes are less than we have allowed
            // now make the current window valid
            while((right - left + 1) - maxFreq > k && left < right){
                freq[s.charAt(left) - 'A']--;
                // now update the max Freq
                left++;
            }
            if((right - left + 1) - maxFreq  <= k){
                // update the maxLength
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }

        return maxLength;
    }
}
